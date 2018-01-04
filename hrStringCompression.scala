object Solution {

  def main(args: Array[String]) {
    val input = io.StdIn.readLine()
    val inputLength = input.length
    def compress(str: String = input, index: Int = 0, builderStr: List[String] = List(), multi: Int = 0, prior: String = " "): String = {
      if (index < inputLength) {
        val item = str(index).toString
        //if item is the first of its kind -> add it, do nothing else
        if (multi == 0 && item != prior) {
          compress(str, index + 1, item :: builderStr, multi + 1, item)
        } 
        //more than one of this item -> increment multi counter, do nothing else
        else if (item == prior) {
          compress(str, index + 1, builderStr, multi + 1, item)
        } 
        //if multi is only one, add the item without the prior series number, set multi to one
        else if (multi == 1) {
          compress(str, index + 1, item :: builderStr, 1, item)
        } 
        //if multi > one -> add prior series number, add and this item, multi should reflect one for that item
        else /*if (multi > 1) */ {
          compress(str, index + 1, item :: (multi.toString :: builderStr), 1, item)
        }
      } //at end of the string
      //if there was more than one of the last item, add the count and return the reversed string
      else if (multi > 1) (multi :: builderStr).reverse.mkString
      //otherwise return the reversed string
      else builderStr.reverse.mkString
    }
    println(compress(input))
  }
}