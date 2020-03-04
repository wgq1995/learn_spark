import java.io.File
import scala.io.Source

object WordCount {
  def main(args: Array[String]): Unit = {
    // 读取文件
    val dirFile = new File("./wordCountFiles")
    val files = dirFile.listFiles().toList
    for (file <- files){
      println(file)
    }

    val wordsMap = scala.collection.mutable.Map[String, Int]()
    // 对每个文件
    files.foreach(
      // 对每一行
      file => Source.fromFile(file).getLines().foreach(
        line => line.split(" ").foreach(
          word => {
            if (wordsMap.contains(word)){
              wordsMap(word) += 1
            }
            else{
              wordsMap += (word -> 1)
            }
          }
        )
      )
    )
    // 打印结果
    wordsMap.foreach(println)
  }
}
