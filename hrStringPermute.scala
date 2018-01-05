object Solution {

  def main(args: Array[String]) {
    val numInput = io.StdIn.readInt()

    def permute(item: String): String = {
      val str = item.toArray
      val answer = (for {
        i <- 0 until str.length by 2
      } yield List(str(i + 1), str(i))).flatten
      answer.mkString
    }

    def recur(times: Int = 0): Unit = {
      if (times >= numInput) ()
      else {
        val input = io.StdIn.readLine()
        if (input.length % 2 == 0) {
          val output = permute(input)
          println(output)
          recur(times + 1)
        } else {
          println("Not even input.")
          recur(times + 1)
        }
      }
    }

    recur()
  }
}