abstract class Vehicle {
  val wheels: Int
  val id: Int
  val parts: Array[Part]
  override def toString: String = "ID: %s, Wheels: %s" format (id, wheels)

}
