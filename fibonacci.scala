object Solution {
  
  def fib(n: Long) = {
    val mod = (Math.pow(10, 8) + 7).toLong
    def rec(current: Long, previous: Long, times: Long, peak: Long): Long = {
      if(times < peak) rec((current % mod) + (previous % mod), current, times + 1, peak)
      else previous % mod
    }
    rec(1, 0, 0, n)
  }

  def main(args: Array[String]) {
    val repeat = io.StdIn.readInt()
    def recur(times: Int = 0): Unit = {
      if(times < repeat) {
        val num = io.StdIn.readLong()
        val ans = Solution.fib(num)
        println(ans)
        recur(times + 1)
      } else ()
    }
    recur()
  }
}
