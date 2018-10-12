class Garage(var vehicles: scala.collection.mutable.ArrayBuffer[Vehicle], var open: Boolean, var employees: scala.collection.mutable.ArrayBuffer[Employee]) {

  def this(vehicles: scala.collection.mutable.ArrayBuffer[Vehicle], open: Boolean) = this(vehicles,open,scala.collection.mutable.ArrayBuffer[Employee]())

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
    employees.append(new Employee(scala.util.Random.alphanumeric.take(5).mkString + scala.util.Random.alphanumeric.take(5).mkString))
  }

  def fixVehicle(id: Int)={
    if(open) {
      val employee = pickEmployee()
      val a = vehicles.filter(_.id == id)
      val b = a(0)
      var toFix = 0
      val c = vehicles.indexOf(b)
      b.parts.map(x=>if(x.broken == true){toFix+=1})
      employee.time += toFix
      println("There are " + toFix + " broken parts")
      println("The cost to fix this is " + calcBill(b))
      b.parts.map(x=>x.broken=false)
      vehicles = vehicles.updated(c, b)
    }
    else{
      println("The garage is closed, so nothing can be fixed")
    }

  }

  def calcBill(vehicle: Vehicle)={
    var cost = 0
    vehicle.parts.map(x=> if (x.broken) {cost += 20 })
    cost
  }

  def viewContents(): Unit ={
    println("***The contents of the garage are:***")
    vehicles.foreach(println)
  }

  def openGarage()={
    open = true
    for(i<-1 to scala.util.Random.nextInt(11)+10){
      vehicles.append(Generator.makeCar())
    }
  }

  def closeGarage()={
    open = false
    vehicles = scala.collection.mutable.ArrayBuffer[Vehicle]()
  }

  def pickEmployee()={
    var times = scala.collection.mutable.ArrayBuffer[Int]()
    employees.map(x=>times.append(x.time))
    var min = times.reduceLeft(_ min _)
    val newEmployee = employees.filter(_.time == min)
    newEmployee(0)
  }

//  def timeToFix(vehicle: Vehicle)={
//    var noBroken = 0
//    vehicle.parts.map(x=>if(x.broken == true){noBroken+=1})
//  }
}
