// 伴生对象：class和object后面的名称相同，同一个文件中

class Person {
  private val id = Person.newPersonId()
  private var name = ""
  def this(name: String){
    this()
    this.name = name
  }
  def info(): Unit ={
    println(name, id)
  }
}

object Person {
  private var lastId = 0
  private def newPersonId(): Int ={
    lastId += 1
    lastId
  }

  def main(args: Array[String]): Unit = {
    val person1 = new Person("a")
    val person2 = new Person("b")
    person1.info()
    person2.info()
  }
}
