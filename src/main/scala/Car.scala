class Car(val wheels: Int, val id: Int, val doors: Int, val model: String, val parts: Array[Part],
          override var timeStart: Int, override var timeEnd: Int, var servedBy: String) extends Vehicle {
  override def toString: String = {
    var noBroken = 0
    parts.map(x=> if(x.broken){noBroken+=1})
    "ID: %s, Wheels: %s, Doors %s, Model: %s, No. Broken: %s, Start: %s, End: %s, Served By: %s" format (id, wheels, doors, model, noBroken, timeStart, timeEnd, servedBy)
  }


  def this(wheels: Int, id: Int, doors: Int, model: String) = this(wheels,id,doors,model, Array.fill(scala.util.Random.nextInt(10)+10){new Part()},0,0,"")
  def this(wheels: Int, id: Int, doors: Int, model: String, parts: Array[Part]) = this(wheels,id,doors,model,parts,0,0,"")


}
