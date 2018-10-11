object Runner {

  def main(args: Array[String]) {

    val a = new Car(4, 123, 2, "AB-142")
    val b = new Bike(2, 2345)
    val d = Array.fill(scala.util.Random.nextInt(10)+10){new Part()}
    d.map(x => if(scala.util.Random.nextInt(2) == 0){x.broken = false})
    val c = new Car(4,736,3,"oa-999", d)


    val garage = new Garage(scala.collection.mutable.ArrayBuffer[Vehicle](a,b), true)
    garage.addVehicle(c)

    for(i<-1 to 20){
      println(Generator.makeCar())
    }



//
//    garage.closeGarage()
//    garage.fixVehicle(123)
//    garage.openGarage()
//    garage.fixVehicle(123)






    }



}