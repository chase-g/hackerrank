object Solution {

    class Filtration {
      import collection.mutable.Map
      
      def sift(nums: Array[Int], peak: Int): List[Int] = {
        val m: Map[Int, Int] = Map()
        val len = nums.length
        def siftIn(ns: Array[Int], index: Int, acc: List[Int], goal: Int): List[Int] = {
          if(index >= len) ns.toList.filter(x => acc.contains(x))
          else {
            val n = ns(index)
            if(m.contains(n)) {
              m(n) += 1
              if(m(n) >= goal) siftIn(ns, index + 1, n :: acc, goal)
              else siftIn(ns, index + 1, acc, goal)
            }
            else {
              m += (n -> 1) 
              if(m(n) >= goal) siftIn(ns, index + 1, n :: acc, goal)
              else siftIn(ns, index + 1, acc, goal)
              }
          }
        }
        (siftIn(nums, 0, List(), peak)).distinct
      }
      
    }
  
    def main(args: Array[String]) {
      val repeat = io.StdIn.readInt()
      def recur(times: Int = 0): Unit = {
        if(times < repeat) {
          val nk = io.StdIn.readLine().split(" ").map(_.toInt)
          val n = nk(0)
          val k = nk(1)
          val numbers = io.StdIn.readLine().split(" ").map(_.toInt)
          val c = new Filtration
          val ans = (c.sift(numbers, k))
          if(ans.length == 0) println(-1)
          else { for(i <- ans) print(i + " "); println() }
          recur(times + 1)
        } else ()
      }
      recur()
    }
}