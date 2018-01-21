object Solution {
  def main(args: Array[String]) {
    val number = io.StdIn.readInt()
    val multiples = io.StdIn.readInt()

    class disjointSet {

      import scala.collection.mutable.Map
      private val trees: Map[Int, Set[Int]] = Map()
      private var rank = 0

      def find(x: Int, root: Int = 0): Option[Int] = {
        if (root < trees.size && trees(root).contains(x)) Some(root)
        else if (root < trees.size) find(x, root + 1)
        else None
      }

      def add(x: Int): Unit = {
        val exists = find(x)
        if (exists == None) {
          trees += (rank -> Set(x))
          rank = trees.size
        }
      }

      def union(x: Int, y: Int): Unit = {
        val xRoot = find(x).getOrElse(-1)
        val yRoot = find(y).getOrElse(-1)
        if (xRoot != -1 && yRoot != -1) {
          if (xRoot == yRoot) ()
          else if (xRoot < yRoot) {
            trees(xRoot) = trees(xRoot) ++ trees(yRoot)
            trees(yRoot) = Set()
            rank = yRoot
          } else {
            trees(yRoot) = trees(yRoot) ++ trees(xRoot)
            trees(xRoot) = Set()
            rank = xRoot
          }
        } else ()
      }

      def show(): Unit = {
        println(trees)
      }

      def rootSizes(): List[Int] = {
        val sizesList = (for {
          i <- 0 until trees.size
        } yield trees(i).size).toList
        sizesList
      }
    }

    val prisoners = new disjointSet

    def process(times: Int = 0): Unit = {
      if (times < multiples) {
        val group = io.StdIn.readLine().split(" ").map(_.toInt)
        prisoners.add(group(0))
        prisoners.add(group(1))
        prisoners.union(group(0), group(1))
        process(times + 1)
      } else ()
    }

    def pickBuses(): Unit = {
      val roots = prisoners.rootSizes
      val groupCost = (for {
        i <- roots
      } yield Math.ceil(Math.sqrt(i))).sum
      val totalCost = groupCost + (number - roots.sum)
      println(totalCost.toInt)
    }

    process()
    pickBuses()
  }
}
