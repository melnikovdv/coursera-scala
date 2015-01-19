object mergesort {
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, scd) = xs splitAt n
      merge(msort(fst), msort(scd))
    }
  }

  val nums = List(2, -4, 5, 7 ,1)
  msort(nums)

  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil     => Nil
    case y :: ys => y * y :: squareList(ys)
  }
  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => x * x)

  squareList(nums)
  squareList2(nums)

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil      => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }

  pack(List("a", "a", "a", "b", "c", "c", "a"))

  def encode[T](xs: List[T]): List[(T, Int)] = pack(xs) map (ys => (ys.head, ys.length))
  // List(("a", 3), ("b", 1), ("c", 2), ("a", 1))
  encode(List("a", "a", "a", "b", "c", "c", "a"))

  def concat[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys) (_ :: _)

  val l = List(1,2,3,4)
  concat(l, List(5,6))


}