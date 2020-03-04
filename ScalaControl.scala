//控制结构
object ScalaControl {
  def ifTest(): Unit = {
    val x = 6
    println("number is " + x)
    if (x > 0) {
      println("x is positive")
    }
    else if (x == 0) {
      println("x is zero")
    }
    else {
      println("x is negative")
    }
  }
  def whileTest(): Unit = {
    //第一种while循环
    var i = 3
    while (i > 0){
      println(i)
      i -= 1
    }
    //第二种while循环
    var j = 3
    do {
      println(j)
      j -= 1
    }while (j > 0)
  }
  def forTest(): Unit = {
    /*
    两种生成器：
      1 to 5 --> [1,2,3,4,5] 左闭右闭
      1 until 5 --> [1,2,3,4] 左闭右开
      by 表示步长
      循环元素控制可以用一个if条件控制(同Python)
     */
    //单循环
    println("单循环")
    for (i <- 1 until 10 by 2 if i%3==0){
      println(i)
    }
    //双重循环1
    println("双重循环1")
    for (i <- 1 to 2;
         j <- 4 to 5) {
      println(i, j)
    }
    //双重循环2
    println("双重循环2")
    for (i <- 1 to 2) {
      for (j <- 4 to 5) {
        println(i, j)
      }
    }
  }
  def forYieldTest(): Unit = {
    /*
    for 推导式
     */
    val r = for (i <- 1 to 5) yield (i)
    println(r)
  }
  def main(args: Array[String]): Unit = {
    //ifTest()
    //whileTest()
    //forTest()
    forYieldTest()
  }
}
