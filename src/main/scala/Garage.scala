class Garage(var vehicles: scala.collection.mutable.ArrayBuffer[Vehicle]) {

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
    val foundVehicle = vehicles.filter(_.id == id)
    var vehicle = foundVehicle(0)
  }

}
