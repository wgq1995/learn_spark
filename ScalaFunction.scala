// 函数式编程

object ScalaFunction {
  // 像定义变量一样定义函数
  val counter: Int => Int = {(v) => v + 2}
  // 匿名函数
  val counter2 = (num: Int) => println(num * 2)
  // 闭包函数，闭包每次执行都会生成一个新的闭包（可以改变more的值）
  var more = 1
  val counter3 = (num: Int) => {
    println(num + more)
    more += 1
  }
  // 三种函数例子
  def functionTest: Unit ={
    /*
    1. 定义变量一样定义函数
    2. 匿名函数
    3. 闭包，也是一种函数，和普通函数区别很大，可以用输入变量之外的值
     */
    println(counter(5))
    // 匿名函数
    val myList = List(1, 2, 3, 4)
    myList.foreach(counter2)
    counter3(9)
    counter3(20)
  }
  // 占位符
  def placeholderTest: Unit ={
    val numList = List(1, 2, 3, 4, 5)
    println(numList.filter(x => x % 2 == 0))
    // 占位符用法
    println(numList.filter(_ % 2 == 0))
  }
  def main(args: Array[String]): Unit = {
    //functionTest
    placeholderTest
  }
}
