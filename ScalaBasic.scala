import java.io.FileNotFoundException

//基本语法
object ScalaBasic{
  def varianceTest(): Unit = {
    /*
    声明变量：
    val--不可变
    var--可变
    变量类型可声明也可以不声明
      */
    val myStr1: String = "ab"
    println(myStr1)
    var myStr2 = "cd"
    println(myStr2)
    myStr2 = "ef"
    println(myStr2)
  }
  def operationTest(): Unit = {
    /*
    操作符
    所有变量都是对象，可以调用[.操作方法]
     */
    val sum1 = 5 + 3
    println(sum1)
    val sum2 = 5.+(3)
    println(sum2)
    println(3 max 5)
  }
  def rangeTest(): Unit = {
    /*
    range: 1 range 5 by 1 --> [1,2,3,4,5]
    until: 1 until 5 by 1 --> [1,2,3,4]
    步长默认是1, 可不指定
    其他类型（浮点数等）也可以range
     */
  }
  def readTest(): Unit = {
    /*
    控制台读取数据
    不同的方法读取不同类型的数据
    如果读取任意类型的数据，用readLine
     */
    //var num = readInt()
    //println(num)
    var myVar = readLine()
    println(myVar)
  }
  def readFileTest(): Unit = {
    import java.io.PrintWriter
    // 写
    val out = new PrintWriter("./myFile.txt")
    for (i <- 1 to 5){
      out.println(i)
    }
    out.close()
    // 读
    import scala.io.Source
    val inputFile = Source.fromFile("./myFile.txt")
    val lines = inputFile.getLines()
    for (line <- lines){
      println(line)
    }
    inputFile.close()
  }
  def exceptionTest(): Unit = {
    /*
    try - catch 方式捕获异常
     */
    import java.io.FileReader
    import java.io.FileNotFoundException
    try {
      val f = new FileReader("./noFile.txt")
    }
    catch {
          //文件不存在时
      case ex: FileNotFoundException =>
        println("文件不存在")
    }
    finally  {
      println("没有错误")
    }
  }
  def main(args: Array[String]): Unit = {
    //varianceTest()
    //operationTest()
    //readTest()
    //readFileTest()
    exceptionTest()
  }
}


