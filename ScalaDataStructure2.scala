object ScalaDataStructure2 {
  def arrayTest(): Unit = {
    /*
    可变， 数据类型相同
     */
    val myArray1 = new Array[Int](3)
    for (i <- 0 until 3) {
      myArray1(i) = i * i
    }
    for (i <- 0 until 3) {
      println(myArray1(i))
    }
    val myArray2 = Array(1, 2, 3)
    // 直接打印不显示元素，只显示地址
    println(myArray2)
    // 多维数组
    val myMatrix = Array.ofDim[Int](3, 4)
    for (i <- 0 until 3; j <- 0 until 4){
      myMatrix(i)(j) = i - j
    }
    println(myMatrix(0)(1))
    // 不定长数组
    import scala.collection.mutable.ArrayBuffer
    val myArray3 = ArrayBuffer(1, 2, 3)
    // 在末尾加一个元素
    myArray3 += 4
    println(myArray3)
    // 在索引2处把后面的元素插进去
    myArray3.insert(2, -1, -2)
    println(myArray3)
    // 把第一个等于2的元素删除
    myArray3 -= 2
    println(myArray3)
    // 从索引为1处删除元素，删除两个
    myArray3.remove(1, 2)
    println(myArray3)

  }
  def tupleTest(): Unit = {
    /*
    元组里的元素类型可以不同
     */
    val myTuple = (1, "a", 2.2)
    println(myTuple)
    // 索引元组里的元素
    println(myTuple._1)
  }
  def main(args: Array[String]): Unit = {
    //iteratorTest()
    //arrayTest()
    //tupleTest()
  }
}
