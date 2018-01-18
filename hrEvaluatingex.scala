object Solution {

  def main(args: Array[String]) {
    def eval(num: Double, repeat: Int = 10)(numer: Double = num, denom: Double = 1, acc: Double = 1, times: Int = 1): Unit = {
      if (times == repeat) println(f"$acc%1.4f")
      else eval(num, 10)(Math.pow(num, times + 1), denom * (times + 1), acc + (numer / denom), times + 1)
    }
    def implement(recur: Int, times: Int = 0): Unit = {
      if (times == recur) ()
      else {
        eval(io.StdIn.readDouble())()
        implement(recur, times + 1)
      }

    }
    implement(io.StdIn.readInt())
  }
}
