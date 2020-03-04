import org.graalvm.compiler.core.common.util.IntList
// scala常用数据结构

object ScalaDataStructure {
  def collectionTest(): Unit = {
    /*
    可变容器：scala.collection.mutable
    不可变容器：scala.collection.immutable
     */
  }
  def listTest(intList: List[Int]): Int = {
    /*
    列表，里面数据类型相同
    不可变对象序列
     */
    //val intList = List(4, 2, 3, 1)
    println(intList.head)
    println(intList.tail)
    println(intList)
    // 构建一个[新的]列表，在原来的最左边加一个元素
    val otherList = 1::intList.dropRight(1)
    println(otherList)
    val result = intList.zip(otherList).map(
      pair => 0.max(pair._1 - pair._2)
    ).sum
    println(result)
    result
    // 用左边添加元素的方法构建新列表
  }
  def setTest(): Unit = {
    /*
    集合有可变不可变两种，默认不可变
     */
    var mySet = Set("a", "b")
    // 这里是生成一个新对象，不是在原set里加
    mySet += "c"
    println(mySet)
    import scala.collection.mutable.Set
    // 这里是一个可变集合，在原集合中添加元素
    val myMutableSet = Set("a", "b")
    myMutableSet += "c"
  }
  def mapTest(): Unit = {
    /*
    可变不可变两种，默认不可变
     */
    // 不可变map
    val mySet = Map(
      "a" -> 1,
      "b" -> 2,
      "c" -> 3
    )
    println(mySet)
    println(mySet("a"))
    // 是否包含某个key
    println(mySet.contains("d"))
    // 可变map
    import scala.collection.mutable.Map
    val mySet2 = Map(
      "a" -> 1,
      "b" -> 2,
      "c" -> 3
    )
    mySet2("a") = 0
    println(mySet2)
    mySet2 += ("d" -> 4)
    println(mySet2)
    // 遍历map
    for ((k, v) <- mySet2) {
      println(k, v)
    }
    println(mySet2.keys)
  }
  def main(args: Array[String]): Unit = {
    val intList = List(4, 2, 3, 1)
    println(listTest(intList))
    //setTest()
    //mapTest()
  }
}
