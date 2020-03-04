//类，面向对象

class Counter {
  private var privateValue = 0
  def value = privateValue
  def value_=(newValue: Int) {
    privateValue = newValue
  }
  // Unit 表示什么都不返回
  def increment(step: Int): Unit = {
    privateValue += step
  }
  def current(): Int = {
    privateValue
  }
}

class Counter2 {
  private var value = 0
  private var name = ""
  private var mode = 1
  def this(name: String){// 第一个辅助构造器
    this() // 调用主构造器
    this.name = name
  }
  def this(name: String, mode: Int){// 第一个辅助构造器
    this(name) // 调用第一个辅助构造器
    this.mode = mode
  }
  def increment(step: Int): Unit = {
    value += step
  }
  def current(): Int = {
    value
  }
  def info(): Unit = {
    printf("Name: %s and mode is %d\n", name, mode)
  }
}

// 也可以这样定义，主构造器写在类括号里
class Counter3(val name: String, val mode: Int) {
  private var value = 0
  def info(): Unit = {
    printf("Name: %s and mode is %d\n", name, mode)
  }
}

object ScalaClass {
  def main(args: Array[String]): Unit = {
    // 设置值
//    val myCounter = new Counter
//    println("原来的myValue值", myCounter.value)
//    myCounter.value = 5
//    println("myValue值", myCounter.value)
//    myCounter.increment(3)
//    println("改变后的myValue值", myCounter.current())
    // 构造器
    val myCounter1 = new Counter2()
    val myCounter2 = new Counter2("Runner")
    val myCounter3 = new Counter2("Timer", 2)
    myCounter1.info()
    myCounter1.increment(1)
    printf("Current Value is: %d\n", myCounter1.current())
    myCounter2.info()
    myCounter3.info()
    val myCounter4 = new Counter3("counter", 1)
    myCounter4.info()
  }
}
