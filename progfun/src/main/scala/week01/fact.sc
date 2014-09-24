object exercise {
  def fact(n: Int): Int =
    if (n == 0)
      1
    else
      n*fact(n-1)

  fact(5)
  fact(4)
  fact(3)
  fact(2)

  def factTailed(n: Int): Int = {

    def loop(acc: Int, n: Int): Int =
      if (n == 0)
        acc
      else
        loop(acc*n, n-1)

    loop(1, n)
  }

  factTailed(5)
  factTailed(4)
  factTailed(3)
  factTailed(2)

}


