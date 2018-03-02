object Solution {

  class Ship {
    def notPrimes(): Array[Boolean] = { // Sieve of Erastosthenes
      val notPrime = new Array[Boolean](1000001) // Create array of booleans, each initially false
      notPrime(0) = true
      notPrime(1) = true
      for (i <- 2 until notPrime.length) { // For each index in the array of booleans
        // set all the multiples of each prime number to true
        if (notPrime(i) == false) {
          for (n <- i until notPrime.length by i) {
            if (n != i) {
              notPrime(n) = true
            }
          }
        }
      }
      notPrime
    }

    val notPrime: Array[Boolean] = notPrimes() //holds array of booleans marking non prime indexes

    def findZeros(x: String): Boolean = {
      if (x.contains("0")) true
      else false
    }
    
    def leftwisePrime(x: String): Boolean = {
      if (!notPrime(x.toInt)) {
        val shortStr = x.slice(1, x.length)
        if (shortStr == "") true
        else leftwisePrime(shortStr)
      } else false
    }

    def rightwisePrime(x: String): Boolean = {
      if (!notPrime(x.toInt)) {
        val shortStr = x.slice(0, x.length - 1)
        if (shortStr == "") true
        else rightwisePrime(shortStr)
      } else false
    }

    def assignPlace(x: String): String = {
      val notPrimeorZeros = notPrime(x.toInt) || findZeros(x)
      if (notPrimeorZeros) "DEAD"
      else {
        val right = rightwisePrime(x)
        val left = leftwisePrime(x)
        if(right && left) "CENTRAL"
        else if(!right && left) "LEFT"
        else if(right && !left) "RIGHT"
        else "DEAD"
      }
    }
    
  }

  val pirateShip = new Ship

  def main(args: Array[String]) {

    val numRepeat = io.StdIn.readInt()
    def inputOutput(times: Int = 0): Unit = {
      if (times < numRepeat) {
        val id = io.StdIn.readLine()
        println(pirateShip.assignPlace(id))
        inputOutput(times + 1)
      } else ()
    }

    inputOutput()
  }
}