import week03._

object Nth {
  def nth[T](n: Int, list: List[T]): T =
    if (list.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) list.head
    else nth(n - 1, list.tail)

  val list = new Cons(1, new Nil)

  nth(2, list)
  nth(-1, list)

}