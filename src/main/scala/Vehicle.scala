abstract class Vehicle(val wheels: Int, val id: Int) {
  override def toString: String = "ID: %s, Wheels: %s" format (id, wheels)
}
