import week04._
object exprs {
  def show(e: Expr): String = e match {
    case Number(x) => x.toString
    case Var(x) => x
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => show(e1) + " * " + show(e2)
  }
  show(Sum(Number(1), Number(44)))

  // should print as “2 * x + y”. But
  show(Sum(Prod(Number(2), Var("x")), Var("y")))

  // should print as "(2 + x) * y"
  show(Prod(Sum(Number(2), Var("x")), Var("y")))
}