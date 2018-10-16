import scala.collection.mutable.ArrayBuffer

class Garage(var vehicles: scala.collection.mutable.ArrayBuffer[Vehicle], var open: Boolean, var employees: scala.collection.mutable.ArrayBuffer[Employee], var dayProfit: Int) {

  def this(vehicles: scala.collection.mutable.ArrayBuffer[Vehicle], open: Boolean) = this(vehicles,open,scala.collection.mutable.ArrayBuffer[Employee](),0)

  def addVehicle(vehicle: Vehicle): Unit ={
    vehicles.append(vehicle)
  }

  def removeVehicle(id: Int): Unit ={
    val newVehicles = vehicles.filter(_.id != id)
    vehicles = newVehicles
  }

  def removeVehicles(kind: String): Unit ={
    val newVehicles = vehicles.filter(_.getClass.toString.substring(6) != kind)
    vehicles = newVehicles
  }

//  def removeVehicle(model: String)={
//    val newVehicles = vehicles.filter(_.model != null)
//    vehicles = newVehicles
//  }

  def newEmployee(): Unit ={
    employees.append(new Employee(scala.util.Random.alphanumeric.take(5).mkString +" "+ scala.util.Random.alphanumeric.take(5).mkString))
  }

  def fixVehicle(index: Int): Unit ={
    if(open) {
      val employee = pickEmployee()
      val b = vehicles(index)
      b.timeStart = employee.time
      b.servedBy = employee.name
      var toFix = 0
      b.parts.map(x=>if(x.broken){toFix+=1})
      employee.time += toFix
      b.timeEnd = employee.time
      println("There are " + toFix + " broken parts")
      println("The cost to fix this is " + calcBill(b))
      dayProfit += calcBill(b)
      b.parts.map(x=>x.broken=false)
      vehicles = vehicles.updated(index, b)
    }
    else{
      println("The garage is closed, so nothing can be fixed")
    }

  }

  def fixVehicle(vehicle: Vehicle): Unit ={
    if(open) {
      val employee = pickEmployee()
      val b = vehicle
      val index = vehicles.indexOf(b)
      b.timeStart = employee.time
      b.servedBy = employee.name
      var toFix = 0
      b.parts.map(x=>if(x.broken){toFix+=1})
      employee.time += toFix
      b.timeEnd = employee.time
      println("There are " + toFix + " broken parts")
      println("The cost to fix this is " + calcBill(b))
      dayProfit += calcBill(b)
      b.parts.map(x=>x.broken=false)
      vehicles = vehicles.updated(index, b)
    }
    else{
      println("The garage is closed, so nothing can be fixed")
    }

  }

  def calcBill(vehicle: Vehicle): Int ={
    var cost = 0
    vehicle.parts.map(x=> if (x.broken) {cost += 20 })
    cost
  }

  def viewContents(): Unit ={
    println("***The contents of the garage are:***")
    vehicles.foreach(println)
  }

  def openGarage(): Unit ={
    open = true
    dayProfit = 0
    for(i<-1 to scala.util.Random.nextInt(11)+10){
      if(scala.util.Random.nextInt(2) == 0){
        vehicles.append(Generator.makeCar())
      }
      else {
        vehicles.append(Generator.makeBike())
      }
    }

  }

  def closeGarage(): Unit ={
    open = false
    println("The day's profit is " + dayProfit)
    vehicles = scala.collection.mutable.ArrayBuffer[Vehicle]()
  }

  def pickEmployee(): Employee ={
    val times = scala.collection.mutable.ArrayBuffer[Int]()
    employees.map(x=>times.append(x.time))
    val min = times.min
    val newEmployee = employees.filter(_.time == min)
    newEmployee(0)
  }

//  def timeToFix(vehicle: Vehicle)={
//    var noBroken = 0
//    vehicle.parts.map(x=>if(x.broken == true){noBroken+=1})
//  }
  def simDay(): ArrayBuffer[Unit] ={
  closeGarage()
  openGarage()
//  for(i<-0 to vehicles.size - 1){
//    fixVehicle(i)
//  }
  vehicles.foreach(fixVehicle(_))
  viewContents()
  employees.map(x=>println(x.toString()))
}

}
