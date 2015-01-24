import _root_.intsets.{NonEmpty, Empty}

trait ListCustom[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: ListCustom[T]
  def prepend[U >: T](elem: U): ListCustom[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: ListCustom[T]) extends ListCustom[T] {
  def isEmpty = false
}

object Nil extends ListCustom[Nothing] {
  def isEmpty: Boolean = true

  override def tail: Nothing = throw new NoSuchElementException("Nil.head")

  override def head: Nothing = throw new NoSuchElementException("Nil.tail")
}

object Test {
  val x: ListCustom[String] = Nil
  def f(xs: ListCustom[NonEmpty], x: Empty) = xs prepend x
}

object ListObj {
  def apply[T](x1: T, x2: T): ListCustom[T] = new Cons(x1, new Cons(x2, new Nil))
  def apply[T]() = Nil
  def apply[T](x: T): ListCustom[T] = new Cons(x, Nil)
}