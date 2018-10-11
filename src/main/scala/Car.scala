class Car(val wheels: Int, val id: Int, val doors: Int, val model: String, val parts: Array[Part]) extends Vehicle {
  override def toString: String = "ID: %s, Wheels: %s, Doors %s, Model: %s" format (id, wheels, doors, model)


  def this(wheels: Int, id: Int, doors: Int, model: String) = this(wheels,id,doors,model, Array.fill(scala.util.Random.nextInt(10)+10){new Part()})


}
