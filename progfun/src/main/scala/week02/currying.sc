object exercise {

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)

  product(x => x * x)(3, 4)

  def fact(n: Int): Int = product(x => x)(1, n)

  fact(3)
  fact(4)
  fact(5)

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)

  product2(x => x * x)(3, 4)

  def fact2(n: Int): Int = product2(x => x)(1, n)
  fact2(3)
  fact2(4)
  fact2(5)


}