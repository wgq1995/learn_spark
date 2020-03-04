//数据集合操作
//list,set等数据集合

object ScalaSet {
  // 定义数据
  val myList = List(1, 2, 3, 4, 5)
  val myMap = Map(
    "a" -> 1,
    "b" -> 2,
    "c" -> 3
  )
  val strList = List("first", "second", "third")
  // for 遍历
  def forTest(): Unit ={
    // 遍历list
    for (elem <- myList){
      println(elem)
    }
    // 遍历map
    for ((k, v) <- myMap){
      println(k, v)
    }
  }

  // map 操作
  def mapTest(): Unit ={
    val mapList = myList.map((num) => num * num)
    println(mapList)
  }

  // flatMap 操作
  def flatMapTest(): Unit ={
    val currentList = strList.flatMap((s) => s.toList)
    println(currentList)
  }

  // filter 操作
  def filterTest(): Unit ={
    val currentList = strList.filter((s) => ! s.contains("d"))
    println(currentList)
  }

  // reduce 操作
  def reduceTest(): Unit ={
    val currentList1 = myList.reduceLeft((a, b) => a - b)
    println(currentList1)
    val currentList2 = myList.reduceRight((a, b) => a - b)
    println(currentList2)
  }

  // fold 操作, 和reduce同理, 只是给了初始值
  def foldTest(): Unit ={
    val currentList1 = myList.fold(10)((a, b) => a - b)
    println(currentList1)
  }
  def main(args: Array[String]): Unit = {
    //forTest()
    //mapTest()
    //flatMapTest()
    //filterTest()
    //reduceTest()
    //foldTest()
  }
}
