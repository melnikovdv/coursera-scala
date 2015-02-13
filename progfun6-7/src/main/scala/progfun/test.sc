import progfun.Pouring
object test {
  val problem = new Pouring(Vector(4, 9, 19))
  problem.moves
  problem.pathSets.take(3).toList
  problem.solution(17)

}