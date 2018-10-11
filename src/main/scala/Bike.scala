class Bike(val wheels: Int, val id: Int, var broken: Boolean) extends Vehicle {
 // override def toString: String = "ID: %s, Wheels: %s" format (id, wheels)

  def this(wheels: Int, id: Int) = this(wheels,id,true)
}
