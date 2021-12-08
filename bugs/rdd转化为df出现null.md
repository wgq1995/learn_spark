# 问题描述
在使用rdd生产一个dataframe时，某些原数据会变成None

# 问题代码
## 定义基本数据和处理函数

```
data = [
    ('a', 1, [0.01, 0.02, 0.03]),
    ('b', 1, [0.04, 0.05, 0.06]),
    ('b', 2, [0.01, 0.02, 0.03]),
    ('c', 1, [0.04, 0.05, 0.06]),
    ('c', 2, [0.01, 0.02, 0.03]),
    ('c', 3, [0.04, 0.05, 0.06])
]

def gen_feature(features, begin_idx=1, seq_len=3, feature_cnt=3):
    result = [[0] * feature_cnt for _ in range(seq_len)]
    mask = [0] * seq_len
    if features:
        for feature in features:
            seq_index = feature[0] - begin_idx
            result[seq_index] = feature[1:]
            mask[seq_index] = 1
    return result, mask
    
```
## 处理rdd

```
rdd = spark.sparkContext.parallelize(data)
rdd_final = rdd\
    .map(lambda row: (row[0], [[row[1]] + row[2]]))\
    .reduceByKey(lambda a, b: a + b)\
    .map(lambda row: (row[0], *gen_feature(row[1])))
rdd_final.collect()
```
输出结果没有None：

```
[('a', [[0.01, 0.02, 0.03], [0, 0, 0], [0, 0, 0]], [1, 0, 0]),
 ('c',
  [[0.04, 0.05, 0.06], [0.01, 0.02, 0.03], [0.04, 0.05, 0.06]],
  [1, 1, 1]),
 ('b', [[0.04, 0.05, 0.06], [0.01, 0.02, 0.03], [0, 0, 0]], [1, 1, 0])]
```

## 转化为df

```
df = rdd_final.toDF(['flag', 'features', 'mask'])
df.collect()
```
输出结果出现了None:

```
[Row(flag='a', features=[[0.01, 0.02, 0.03], [None, None, None], [None, None, None]], mask=[1, 0, 0]),
 Row(flag='c', features=[[0.04, 0.05, 0.06], [0.01, 0.02, 0.03], [0.04, 0.05, 0.06]], mask=[1, 1, 1]),
 Row(flag='b', features=[[0.04, 0.05, 0.06], [0.01, 0.02, 0.03], [None, None, None]], mask=[1, 1, 0])]
```

# 问题定位
## 查看df.printSchema()


```
root
 |-- flag: string (nullable = true)
 |-- features: array (nullable = true)
 |    |-- element: array (containsNull = true)
 |    |    |-- element: double (containsNull = true)
 |-- mask: array (nullable = true)
 |    |-- element: long (containsNull = true)
```

## 原因分析
变为None的都是gen_feature中用0填充的数据，所以猜测是初始化为int，创建时转为double时出现了问题，这里转化失败不会报错会返回一个None

## 验证
用schema创建df 

```
schema = StructType([
        StructField("flag", StringType(), False),
        StructField("features", ArrayType(
            elementType=ArrayType(
                elementType=DoubleType(),
                containsNull=False
            ),
            containsNull=False
        ), False),
        StructField("mask", ArrayType(
            elementType=LongType(),
            containsNull=False
        ), False)])

df = spark.createDataFrame(rdd_final, schema)
df.collect()
```
运行会报错

```
TypeError: element in array element in array field features: DoubleType can not accept object 0 in type <class 'int'>
```
可以看到是类型转化出现了问题


# 问题解决
将默认值初始化为浮点数


```
def gen_feature(features, begin_idx=1, seq_len=3, feature_cnt=3):
    # 初始化为浮点数
    result = [[0.0] * feature_cnt for _ in range(seq_len)]
    mask = [0] * seq_len
    if features:
        for feature in features:
            seq_index = feature[0] - begin_idx
            result[seq_index] = feature[1:]
            mask[seq_index] = 1
    return result, mask
```
生成的df

```
[Row(flag='b', features=[[0.04, 0.05, 0.06], [0.01, 0.02, 0.03], [0.0, 0.0, 0.0]], mask=[1, 1, 0]),
 Row(flag='a', features=[[0.01, 0.02, 0.03], [0.0, 0.0, 0.0], [0.0, 0.0, 0.0]], mask=[1, 0, 0]),
 Row(flag='c', features=[[0.04, 0.05, 0.06], [0.01, 0.02, 0.03], [0.04, 0.05, 0.06]], mask=[1, 1, 1])]
```

# 反思
要注意pyspark运行过程中的类型变化，初始化的类型和最终类型要保持一致


