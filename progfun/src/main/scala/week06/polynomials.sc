import week06.Poly

object polynomials {
  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0)
  p1 + p2
  p1 ++ p2
  p1.terms(7)


}