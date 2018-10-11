abstract class Vehicle {
  val wheels: Int
  val id: Int
  var broken: Boolean
  override def toString: String = "ID: %s, Wheels: %s, Broken: %s" format (id, wheels, broken)

}
