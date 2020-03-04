// 模式匹配

object ScalaMatch {
  def main(args: Array[String]): Unit = {
    /*
    val colorNum = 3
    // 匹配模式1
    val colorStr1= colorNum match {
      case 1 => "a"
      case 2 => "b"
      // 如果没匹配上，就用下划线 _
      case _ => "c"
    }
    println(colorStr1)
    // 匹配模式2
    val colorStr2 = colorNum match {
      case 1 => "a"
      case 2 => "b"
      // 如果希望用输入的colorNum,可以用unexpected代替其他情况
      case unexpected => unexpected + " is not allowed"
    }
    println(colorStr2)
     */
    /*
    // 类型捕获
    val myList = List(1, 2.5, "a", "b")
    for (elem <- myList){
      val str = elem match {
        case i : Int => i + " is Int"
        case d: Double => d + " is Double"
        case "a" => "a is found"
        case s: String => s + " is String"
        case _ =>"unexpected"
      }
      println(str)
    }
     */
    /*
    // 匹配时加入处理逻辑
    for (elem <- 1 until 5){
      elem match {
        case _ if elem % 2 == 0 => println(elem + " is even")
        case _ => println(elem + " is odd")
      }
    }
     */
    /*
    // case 类
    case class Car(brand: String, price: Int){}
    val myBYD = new Car("BYD", 100)
    val myBMW = new Car("BMW", 200)
    val myQQ = new Car("QQ", 20)
    for (car <- List(myBYD, myBMW, myQQ)){
      car match {
        case Car("BYD", 100) => println("BYD")
        case Car("BMW", 200) => println("BMW")
        case Car(brand, price) => println(brand, price)
      }
     */
    // option 类型，处理多种类型的返回值，已map为例
    // 存在时候会返回一个option的子类some，并将数字封装进去
    // 不存在会返回一个None
    val books = Map(
      "a" -> 1,
      "b" -> 2,
      "c" -> List(1, 2, 3)
    )
    val a = books.get("a")
    val d = books.get("d")
    // 可以用getOrElse取出option里的值
    println(a, d)
    println(a.getOrElse(""))
    println(d.getOrElse("is 'None'"))
    // foreach方法遍历option
    books.get("c").foreach(println)
    }
  }

