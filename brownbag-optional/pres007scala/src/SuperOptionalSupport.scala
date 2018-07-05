
object SuperOptionalSupport {

  def main(args: Array[String]): Unit = {

    def sumIfBothPresent(v1: Option[Int], v2: Option[Int]): Option[Int] = (v1, v2) match {
      case (Some(a), Some(b)) => Some(a + b)
      case (_, _) => None
    }

    assert (sumIfBothPresent(Some(1), Some(2)).contains(3))
    assert (sumIfBothPresent(Some(1), None).isEmpty)
    assert (sumIfBothPresent(None, Some(2)).isEmpty)
    assert (sumIfBothPresent(None, None).isEmpty)

    // assert (sumIfBothPresent(None, None).isDefined)

    def sumIfBothPresent2(v1: Option[Int], v2: Option[Int]): Option[Int] = {
      for {
        a <- v1
        b <- v2
      } yield a + b
    }

    assert (sumIfBothPresent2(Some(1), Some(2)).contains(3))
    assert (sumIfBothPresent2(Some(1), None).isEmpty)
    assert (sumIfBothPresent2(None, Some(2)).isEmpty)
    assert (sumIfBothPresent2(None, None).isEmpty)


    def sumIfBothPresent3(v1: Option[Int], v2: Option[Int]): Option[Int] = {
      v1.zip(v2).map {
        case (a: Int, b: Int) => a + b
      }.headOption
    }

    assert (sumIfBothPresent3(Some(1), Some(2)).contains(3))
    assert (sumIfBothPresent3(Some(1), None).isEmpty)
    assert (sumIfBothPresent3(None, Some(2)).isEmpty)
    assert (sumIfBothPresent3(None, None).isEmpty)

    def noneIfBothEmpty(v1: Option[Int], v2: Option[Int]): Option[Int] = (v1, v2) match {
      case (Some(a), Some(b)) => Some(a + b)
      case (Some(a), None) => v1
      case (None, Some(b)) => v2
      case (None, None) => None
    }

    assert (noneIfBothEmpty(Some(1), Some(2)).contains(3))
    assert (noneIfBothEmpty(Some(1), None).contains(1))
    assert (noneIfBothEmpty(None, Some(2)).contains(2))
    assert (noneIfBothEmpty(None, None).isEmpty)


  }

}
