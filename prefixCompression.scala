object Solution {
  
    def getPrefix(x: String, y: String): List[String] = {
      
      def recur(xt: String, yt: String, ind: Int, acc: List[String]): List[String] = {
        if(ind == xt.length || ind == yt.length) List(acc.reverse.mkString, xt.drop(ind).toString, yt.drop(ind).toString)
        else if(xt(ind) == yt(ind)) {
          val update = xt(ind).toString :: acc 
          recur(xt, yt, ind + 1, update)
        } 
        else List(acc.reverse.mkString, xt.drop(ind).toString, yt.drop(ind).toString)
        
      }
      val ans = recur(x, y, 0, List())
      ans
    }

    def main(args: Array[String]) {
        val strX = io.StdIn.readLine()
        val strY = io.StdIn.readLine()
        val output = getPrefix(strX, strY)
        for(i <- output) println(i.length + " " + i)
    }
}