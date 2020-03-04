/*
特质（trait）
1. 实现了Java中的借口功能
2. 代码重用单元，可以同时拥有抽象方法和具体方法
3. 一个类只能继承一个父类，但是可以继承多个特质，
  从而重用特质中的方法和字段，实现多重继承
 */

// 定义特质，用trait关键词
trait CarId{
  // 抽象字段
  var id: Int
  // 抽象方法
  def currentId(): Int
}

trait CarGreeting{
  // 非抽象方法
  def greeting(msg: String): Unit ={
    println(msg)
  }
}

// 可以用extends把特质加入到类中，后面用with加入更多特质
class BMWCarId extends CarId with CarGreeting {
  override var id: Int = 20000
  override def currentId(): Int = {
    id += 1
    id
  }
}

class BYDCarId extends CarId with CarGreeting {
  override var id: Int = 10000
  override def currentId(): Int = {
    id += 1
    id
  }
}

object ScalaTrait {
  def main(args: Array[String]): Unit = {
    val myCarId1 = new BMWCarId()
    val myCarId2 = new BYDCarId()
    println(myCarId1.currentId())
    println(myCarId2.currentId())
    myCarId1.greeting("this is car1")
    myCarId2.greeting("this is car2")
  }
}
