object Solution {

  def main(args: Array[String]) {

    val numSides = io.StdIn.readInt()

    def getDimensions(acc: List[List[Double]] = List(List()), sidesTotal: Int = 1): List[List[Double]] = {
      val edge = io.StdIn.readLine().split(" ").map(_.toDouble).toList
      val update: List[List[Double]] = edge :: acc
      if (sidesTotal == numSides) update
      else getDimensions(update, sidesTotal + 1)
    }

    def area(polygon: List[List[Double]], components: List[Double] = List(), subtractComps: List[Double] = List(), index: Int = 0): Double = {
      if (index < polygon.length - 1) {
        val subCalc = polygon(index)(0) * polygon(index + 1)(1)
        val subtractCalc = polygon(index)(1) * polygon(index + 1)(0)
        area(polygon, subCalc :: components, subtractCalc :: subtractComps, index + 1)
      } else {
        val subCalc = polygon(index)(0) * polygon(0)(1)
        val subtractCalc = polygon(index)(1) * polygon(0)(0)
        val answer = 0.5 * Math.abs((((subCalc :: components).sum) - (subtractCalc :: subtractComps).sum))
        answer
      }
    }

    val starterList: List[List[Double]] = List()
    println(area(getDimensions(starterList)))
  }
}