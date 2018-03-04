object Solution {
  
  class SuperDigit {
    
    def getSuper(n: String, k: String): Int = {
      def recurSuper(num: String, kNum: String): Int = {
        val subAnswer = num.split("").map(_.toLong).sum
        val ans = subAnswer * kNum.toLong
        if(ans > 9L) recurSuper(ans.toString, "1")
        else subAnswer.toInt
      }
      val answer = recurSuper(n, k)
      answer
    }
    
  }

    def main(args: Array[String]) {
        val numStrs = io.StdIn.readLine().split(" ")
        val n = numStrs(0)
        val k = numStrs(1)
        val c = new SuperDigit
        println(c.getSuper(n,k))
        
    }
}