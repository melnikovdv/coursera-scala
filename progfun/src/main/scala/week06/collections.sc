
object collections {

  val xs = Array(1, 2, 3, 44)
  xs map (x => x * 2)
  val s = "Hello World"
  s filter (c => c.isUpper)
  val r: Range = 1 until 5
  val r2: Range = 1 to 5
  1 to 10 by 3
  6 to 1 by -2
  s exists (c => c.isUpper)
  s forall (c => c.isUpper)
  val pairs = List(1, 2, 3) zip s
  pairs.unzip
  s flatMap (c => List('.', c))
  xs.sum
  xs.product
  (1 to 5) flatMap(x => (1 to 6) map (y => (x, y)))

  def isPrime(n: Int): Boolean = (2 until n) forall( d => n % d != 0)

  isPrime(2)
  isPrime(5)
  isPrime(7)
  isPrime(10)


}