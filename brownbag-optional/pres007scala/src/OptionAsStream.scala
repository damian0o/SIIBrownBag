import scala.collection.immutable

object OptionAsStream {

  def main(args: Array[String]): Unit = {

    val f1: Int = Some(1).fold(2)(identity)

    assert(f1 == 1)

    val f2: Int = None.fold(2)(identity)
    assert(f2 == 2)

    val f3: immutable.Seq[Int] = List(Some(1), Some(2)).flatten


    val f4: Iterable[(Int, Int)] = Some(2).zip(List(1, 2, 3))

    val f5: immutable.Seq[(Some[Int], Int)] = Stream.continually(Some(2)).zip(List(1, 2, 3))

    val f6: immutable.Seq[Int] = f5.flatMap {
      case (Some(a), b) => Some(a + b)
      case _ => None
    }

    println(f6)
    println(f6.toList)

  }

}
