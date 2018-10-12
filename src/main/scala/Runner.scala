object Runner {

  def main(args: Array[String]) {

    val a = Generator.makeCar()
    val b = Generator.makeCar()
    val d = Array.fill(scala.util.Random.nextInt(10)+10){new Part()}
    d.map(x => if(scala.util.Random.nextInt(2) == 0){x.broken = false})
    val c = Generator.makeCar()

//    val q = new Employee("Greg",0)
//    val w = new Employee("Susan",0)
//    var employees = scala.collection.mutable.ArrayBuffer[Employee](q,w)


    val garage = new Garage(scala.collection.mutable.ArrayBuffer[Vehicle](a,b), true)
    garage.addVehicle(c)


    garage.newEmployee()
    garage.newEmployee()

    garage.simDay()




  /*
    Future plans
    Create cumulative cost to keep track of earnings


  */







    }



}