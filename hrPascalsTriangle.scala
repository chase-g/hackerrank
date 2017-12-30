object Solution {

  def main(args: Array[String]) {
    val rowsLimit = io.StdIn.readInt()
    def makeNext(row: List[Int], acc: List[List[Int]], current: Int): List[List[Int]] = {
      if (current == rowsLimit) acc.reverse
      else if (current == acc.length) makeNext(List(), (1 :: row) :: acc, 0)
      else if (current == 0) makeNext(1 :: row, acc, current + 1)
      else {
        val next = acc(0)(current) + acc(0)(current - 1)
        makeNext(next :: row, acc, current + 1)
      }
    }
    val triangle = makeNext(List(), List(), 0)
    for(i <- triangle; n <- 0 to i.length) if(n == i.length) print("\n") else print(i(n) + " ")
  }
}