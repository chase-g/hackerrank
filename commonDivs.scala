object Solution {

  class commonDivs {
    def ncd(x: Int, y: Int): Int = {
      val big = Math.max(x, y)
      val small = Math.min(x, y)

      def runBiggest(num: Int, div: Int = 1, acc: List[Int] = List()): List[Int] = {
        if (num % div == 0) runBiggest(num, div + 1, div :: acc)
        else if (div > num) acc
        else if (div > ((num / 2) + 1)) runBiggest(num, num, acc)
        else runBiggest(num, div + 1, acc)
      }

      def runSmallest(num: Int, divs: List[Int], acc: Int = 0)(index: Int = divs.length - 1): Int = {
        if (index == -1 || num == 0) acc
        else if (num % divs(index) == 0) runSmallest(num, divs, acc + 1)(index - 1)
        else runSmallest(num, divs, acc)(index - 1)
      }

      val premise = runBiggest(big)
      val answer = runSmallest(small, premise)()
      answer
    }
  }

  def main(args: Array[String]) {

    val repeat = io.StdIn.readInt()
    val common = new Solution.commonDivs

    def inputNums(times: Int = 0): Unit = {
      if (times < repeat) {
        val nums = io.StdIn.readLine().split(" ").toList.map(_.toInt)
        val answer = common.ncd(nums(0), nums(1))
        println(answer)
        inputNums(times + 1)
      } else ()
    }

    inputNums()
  }
}