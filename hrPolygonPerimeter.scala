object Solution {

  def main(args: Array[String]) {

    val numSides = io.StdIn.readInt()

    def getDimensions(acc: List[List[Double]] = List(List()), sidesTotal: Int = 1): List[List[Double]] = {
      val edge = io.StdIn.readLine().split(" ").map(_.toDouble).toList
      val update: List[List[Double]] = edge :: acc
      if (sidesTotal == numSides) update
      else getDimensions(update, sidesTotal + 1)
    }

    def edgeLength(x1: Double, y1: Double, x2: Double, y2: Double): Double = {
      val len = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))
      len
    }

    def perimeter(polygon: List[List[Double]], sidesLen: List[Double] = List(), index: Int = 0): Double = {
      if (index < polygon.length - 1) {
        val side = edgeLength(polygon(index)(0), polygon(index)(1), polygon(index + 1)(0), polygon(index + 1)(1))
        perimeter(polygon, side :: sidesLen, index + 1)
      } else {
        val side = edgeLength(polygon(index)(0), polygon(index)(1), polygon(0)(0), polygon(0)(1))
        val answer = (side :: sidesLen).sum
        answer
      }
    }

    val starterList: List[List[Double]] = List()
    println(perimeter(getDimensions(starterList)))
  }
}