object Solution {

  def main(args: Array[String]) {
    val rowsLimit = io.StdIn.readInt()
    def makeNext(row: List[Int], acc: List[List[Int]], index: Int): List[List[Int]] = {
      //if amount is reached, return the reversed triangle list
      if (index == rowsLimit) acc.reverse
      //if index matchs the current triangle height, 
      //prepend 1 to the row and prepend the row to the accumulator on recursive call
      else if (index == acc.length) makeNext(List(), (1 :: row) :: acc, 0)
      //for first row item, prepend 1
      else if (index == 0) makeNext(1 :: row, acc, index + 1)
      //all other items should be the sum of the items in the above row and the same index and index behind
      else {
        val next = acc(0)(index) + acc(0)(index - 1)
        makeNext(next :: row, acc, index + 1)
      }
    }
    val triangle = makeNext(List(), List(), 0)
    //iteratively print a newline when row's end is reached, or else print each row item with a space
    for(i <- triangle; n <- 0 to i.length) if(n == i.length) print("\n") else print(i(n) + " ")
  }
}
