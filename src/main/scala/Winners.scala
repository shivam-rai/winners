
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Winners extends App {
  val finalists = ArrayBuffer[String]()
  final val noOfWinners = args(1).toInt
  populateFinalists()
  pickWinners(shuffleList(), noOfWinners).foreach(println)


  private def pickWinners(shuffledList: ArrayBuffer[String], noOfWinners: Int) = {
    shuffledList.take(noOfWinners)
  }

  private def shuffleList() = {
    scala.util.Random.shuffle(finalists)
  }

  private def populateFinalists(): Unit = {
    Source.fromFile(args(0)).getLines().foreach{
      finalists += _
    }
  }
}
