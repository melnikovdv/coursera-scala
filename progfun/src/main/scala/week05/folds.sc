
object folds {
  val l = List(1,2,3,4)
//
//  l.foldRight(0)((b,a) => b+a)
//  l.foldRight(1)((b,a) => b*a)
//  l.foldLeft(List[Int]())(ff)
//  def ff(a: List[Int], b: Int) = {
//    println("A: " + a)
//    println("B: " + b)
//    println()
//    b :: a
//  }
//  l.foldRight(List[Int]())(ff2)
//  def ff2(a: Int, b: List[Int]) = {
//    println("A: " + a)
//    println("B: " + b)
//    println()
//    a :: b
//  }

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())( (x, y) => f(x) :: y )

  mapFun(l, (x: Int) => x * x)

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)( (_, acc) => acc + 1 )

  lengthFun(l)
}