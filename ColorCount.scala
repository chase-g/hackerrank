object Solution {
  
  class ColorSeq {

    def countColors(group: Array[Char], rg: Int = 0, yb: Int = 0, index: Int = 0): Boolean = {
      if (index == group.length) {
        if (rg == 0 && yb == 0) true
        else false
      } else {
        val color = group(index)
        color match {
          case 'R' => { if (!List(-1,0,1).contains(yb)) false; else countColors(group, rg + 1, yb, index + 1) }
          case 'G' => { if(!List(-1,0,1).contains(yb)) false; else countColors(group, rg - 1, yb, index + 1) }
          case 'B' => { if(!List(-1,0,1).contains(rg)) false; else countColors(group, rg, yb + 1, index + 1) }
          case 'Y' => { if(!List(-1,0,1).contains(rg)) false; else countColors(group, rg, yb - 1, index + 1) }
          case _ => countColors(group, rg, yb, index + 1)
        }
      }
    }

  }

  def main(args: Array[String]) {
    val repeat = io.StdIn.readInt()
    val c = new ColorSeq
    def inputNums(times: Int = 0): Unit = {
      if (times < repeat) {
        val nums = io.StdIn.readLine().toArray
        val answer = c.countColors(nums)
        if (answer == true) println("True")
        else println("False")
        inputNums(times + 1)
      } else ()
    }
    inputNums()
  }
}