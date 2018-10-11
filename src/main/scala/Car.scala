class Car(val wheels: Int, val id: Int, val doors: Int, val model: String, var broken: Boolean) extends Vehicle {
  override def toString: String = "ID: %s, Wheels: %s, Doors %s, Model: %s, Broken: %s" format (id, wheels, doors, model, broken)

  def this(wheels: Int, id: Int, doors: Int, model: String) = this(wheels,id,doors,model,true)
}
