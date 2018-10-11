class Bike(val wheels: Int, val id: Int, val parts: Array[Part]) extends Vehicle {
 // override def toString: String = "ID: %s, Wheels: %s" format (id, wheels)

  def this(wheels: Int, id: Int) = this(wheels,id, Array.fill(scala.util.Random.nextInt(10)+5){new Part()})
}
