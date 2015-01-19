
def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
}

val l = List(1, 3, 5)
insert(2, l)
def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(x) => List()
  case y :: ys => y :: init(ys)
}

init(l)

def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n + 1)

removeAt(1, List('a', 'b', 'c', 'd'))  // List(a, c, d)

def flatten(xs: List[Any]): List[Any] = xs match {
  case List() => List()
  case (z :: zs) :: ys => flatten(z :: zs) ::: flatten(ys)
  case y :: ys => y :: flatten(ys)
}

val list = List(List(1, 1), 2, List(3, List(5, 8)))
flatten(list)
// >   res0: List[Any] = List(1, 1, 2, 3, 5, 8)