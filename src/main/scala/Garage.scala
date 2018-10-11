class Garage(var vehicles: scala.collection.mutable.ArrayBuffer[Vehicle], var open: Boolean) {

  def addVehicle(vehicle: Vehicle)={
    vehicles.append(vehicle)
  }

  def removeVehicle(id: Int)={
    val newVehicles = vehicles.filter(_.id != id)
    vehicles = newVehicles
  }

//  def removeVehicle(model: String)={
//    val newVehicles = vehicles.filter(_.model != null)
//    vehicles = newVehicles
//  }

  def newEmployee(name: String)={
    new Employee(name)
  }

  def fixVehicle(id: Int)={
    if(open) {
      val a = vehicles.filter(_.id == id)
      val b = a(0)
      var toFix = 0
      val c = vehicles.indexOf(b)
      b.parts.map(x=>if(x.broken == true){toFix+=1})
      println("There are " + toFix + " broken parts")
      println("The cost to fix this is " + calcBill(b))
      b.parts.map(x=>x.broken=false)
      vehicles = vehicles.updated(c, b)
      b.parts.map(x=>println(x.toString))
    }
    else{
      println("The garage is closed, so nothing can be fixed")
    }

  }

  def calcBill(vehicle: Vehicle)={
    var cost = 0
    vehicle.parts.map(x=> if (x.broken==true) {cost += 20 })
    cost
  }

  def viewContents(): Unit ={
    println("***The contents of the garage are:***")
    vehicles.foreach(println)
  }

  def openGarage()={
    open = true
  }

  def closeGarage()={
    open = false
    vehicles = scala.collection.mutable.ArrayBuffer[Vehicle]()
  }

}
