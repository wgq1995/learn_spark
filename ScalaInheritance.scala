//继承

//定义抽象类，需要abstract开头
abstract class Car{
  //抽象字段，不设置初始化值就可以，但是必须要有类型
  val carBrand: String
  // 抽象方法，不需要abstract关键字，方法体空着就行
  def info()
  // 定义一个非抽象方法
  def greeting(): Unit = {
    println("this is my car.")
  }
}

//继承抽象类，需要extends关键字
class BMWCar extends Car {
  // 重写父类字段，需要override关键字
  override val carBrand: String = "BMW"
  // 重写抽象方法，可以不写override关键字
  override def info(): Unit = {
    printf("this is a %s car\n", carBrand)
  }
  // 重写父类非抽象方法，必须使用override关键字
  override def greeting(): Unit = {
    println("this is my BMW car")
  }
}

object ScalaInheritance {
  def main(args: Array[String]): Unit = {
    val myCar = new BMWCar()
    myCar.info()
    myCar.greeting()
  }
}
