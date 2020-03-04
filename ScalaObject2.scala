// apply和update方法
class TestApplyClassAndObject{

}

class ApplyTest{
  def apply() = {
    println("apply method in class")
  }
  def greetingOfClass: Unit = {
    println("Greeting method in class")
  }
}

object ApplyTest{
  def apply() = {
    println("apply method in object")
    new ApplyTest()
  }
}
object TestApplyClassAndObject {
  def main(args: Array[String]): Unit = {
    val a = ApplyTest()
    a.greetingOfClass
    a()
  }
}
