import _root_.intsets.{NonEmpty, Empty}

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object Nil extends List[Nothing] {
  def isEmpty: Boolean = true

  override def tail: Nothing = throw new NoSuchElementException("Nil.head")

  override def head: Nothing = throw new NoSuchElementException("Nil.tail")
}

object Test {
  val x: List[String] = Nil
  def f(xs: List[NonEmpty], x: Empty) = xs prepend x
}

object List {
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
  def apply[T]() = Nil
  def apply[T](x: T): List[T] = new Cons(x, Nil)
}