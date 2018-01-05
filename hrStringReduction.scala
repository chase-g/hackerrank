object Solution {

  def main(args: Array[String]) {
    val input = io.StdIn.readLine()
    val inputLen = input.length
    def delDuplicates(index: Int, str: String, acc: List[String]): String = {
      if (index == inputLen) acc.mkString.reverse
      else if (acc.contains(str(index).toString)) delDuplicates(index + 1, str, acc)
      else delDuplicates(index + 1, str, str(index).toString :: acc)
    }
    println(delDuplicates(0, input, List()))
  }
}