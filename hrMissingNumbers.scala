object Solution {

  def main(args: Array[String]) {
    val filler1 = io.StdIn.readLine() 
    val inputArr1 = io.StdIn.readLine().split(" ").map(_.toInt)
    val filler2 = io.StdIn.readLine() 
    val inputArr2 = io.StdIn.readLine().split(" ").map(_.toInt)
    
    val answer = inputArr2.diff(inputArr1).sorted.distinct
    
    for(i <- answer) print(i + " ")
  }
}