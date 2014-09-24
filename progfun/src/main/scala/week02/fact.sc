
def fact(n: Int): Int =
  if (n == 0)
    1
  else
    n*fact(n-1)

fact(5)
fact(4)
fact(3)
fact(2)

def factTailed(n: Int, sum: Int): Int =
  if (n == 0)
    sum
  else
    factTailed(n-1, sum*n)

factTailed(5, 1)
factTailed(4, 1)
factTailed(3, 1)
factTailed(2, 1)


