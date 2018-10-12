class Bike(val wheels: Int, val id: Int, val parts: Array[Part],override var timeStart: Int, override var timeEnd: Int, var servedBy: String) extends Vehicle {
 // override def toString: String = "ID: %s, Wheels: %s" format (id, wheels)

  def this(wheels: Int, id: Int) = this(wheels,id, Array.fill(scala.util.Random.nextInt(10)+5){new Part()},0,0,"")
  def this(wheels: Int, id: Int, parts: Array[Part]) = this(wheels,id,parts,0,0,"")
}
