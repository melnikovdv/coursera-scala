object ScalarProduct {
  def scalarProduct00(xs: List[Double], ys: List[Double]) : Double = {
    (xs zip ys).map(xy => xy._1 * xy._2).sum
  }
  def scalarProduct0(xs: List[Double], ys: List[Double]) : Double = {
    (xs zip ys).map { case (x, y) => x * y}.sum
  }

  def scalarProduct(xs: List[Double], ys: List[Double]) : Double = {
    (for((x, y) <- xs zip ys) yield x * y).sum
  }

  scalarProduct00(List(1,2,3), List(1,2,3))
  scalarProduct0(List(1,2,3), List(1,2,3))
  scalarProduct(List(1,2,3), List(1,2,3))

}