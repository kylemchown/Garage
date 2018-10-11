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
      println("Before fix: " + b.toString)
      val c = vehicles.indexOf(b)
      b.broken = false
      vehicles = vehicles.updated(c, b)
      println("After fic: " + b.toString)
      println("The bill is " + calcBill(b))
    }
    else{
      println("The garage is closed, so nothing can be fixed")
    }

  }

  def calcBill(vehicle: Vehicle)={
    vehicle match{
      case vehicle: Car => 100
      case vehicle: Bike => 50
      case _ => 0
    }
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
  }

}
