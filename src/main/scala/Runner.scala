object Runner {

  def main(args: Array[String]) {

    val a = Generator.makeCar()
    val b = Generator.makeCar()
    val d = Array.fill(scala.util.Random.nextInt(10)+10){new Part()}
    d.map(x => if(scala.util.Random.nextInt(2) == 0){x.broken = false})
    val c = new Car(4,736,3,"oa-999", d)

    val q = new Employee("Greg",21)
    val w = new Employee("Susan",12)
    var employees = scala.collection.mutable.ArrayBuffer[Employee](q,w)


    val garage = new Garage(scala.collection.mutable.ArrayBuffer[Vehicle](a,b), true, employees)
    garage.addVehicle(c)

//    for(i<-1 to 20){
//      println(Generator.makeCar())
//    }
//    garage.closeGarage()
//    garage.viewContents()
//    garage.openGarage()
//    garage.viewContents()


    garage.fixVehicle(736)
    garage.fixVehicle(123)
    garage.fixVehicle(2345)
    garage.employees.map(x=>println(x.toString()))

  /*
    Future plans
    Employees have a 'Time' variable. When working on a vehicle the time it takes is calculated and added to this
    For each vehicle to be fixed it is done by the one with the lowest time

    Vehicles in a Time In and Time Out variable. These will be set to the employee's time before and after fixing it respectively


  */







    }



}