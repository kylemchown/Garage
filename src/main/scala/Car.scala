class Car(wheels: Int, id: Int, val doors: Int, val model: String) extends Vehicle(wheels, id) {
  override def toString: String = "ID: %s, Wheels: %s, Doors %s, Model: %s" format (id, wheels, doors, model)
}
