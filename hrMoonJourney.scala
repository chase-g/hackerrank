object Solution {

  def journeyToMoon(n: Int, astronaut: Array[Array[Int]]): Long = {

    class disjointSet[A] {
      import scala.collection.mutable.Map
      private val trees: Map[Int, Set[A]] = Map()
      private var rank = 0

      def find(x: A, root: Int = 0): Option[Int] = {
        val treeSize = trees.size
        if (root < treeSize && trees(root).contains(x)) Some(root)
        else if (root < treeSize) find(x, root + 1)
        else None
      }

      def add(x: A): Unit = {
        val exists = find(x)
        if (exists == None) {
          trees += (rank -> Set(x))
          rank = trees.size
        }
      }

      def union(x: A, y: A): Unit = {
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
        } else if (xRoot != -1) {
          trees(xRoot) = trees(xRoot) + y
        } else if (yRoot != -1) {
          trees(yRoot) = trees(yRoot) + x
        } else {
          trees += (rank -> Set(x, y))
          rank = trees.size
        }
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

    val countries = new disjointSet[Long]
    for (i <- astronaut) countries.union(i(0), i(1))
    val ctRootSizes = countries.rootSizes
    val extras: Int = n - ctRootSizes.sum
    val tally: List[Long] = ctRootSizes.map(_.toLong) ::: List.fill(extras)(1L)

    var sum: Long = 0L
    var result: Long = 0L

    for (i <- tally) {
      result = result + (sum * i)
      sum = sum + i
    }

    result
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    var n = sc.nextInt();
    var p = sc.nextInt();
    var astronaut = Array.ofDim[Int](p, 2);
    for (astronaut_i <- 0 to p - 1) {
      for (astronaut_j <- 0 to 2 - 1) {
        astronaut(astronaut_i)(astronaut_j) = sc.nextInt();
      }
    }
    val result = journeyToMoon(n, astronaut);
    println(result)
  }
}