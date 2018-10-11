object Runner {

  def main(args: Array[String]) {

    val a = new Car(4, 123, 2, "AB-142")
    val b = new Bike(2, 2345)



    val garage = new Garage(scala.collection.mutable.ArrayBuffer[Vehicle](a,b), true)
    garage.fixVehicle(2345)


    garage.viewContents()

    garage.closeGarage()
    garage.fixVehicle(123)
    garage.openGarage()
    garage.fixVehicle(123)


    var d = Array.fill(scala.util.Random.nextInt(10)+10){new Part()}
    d.map(x => if(scala.util.Random.nextInt(2) == 0){x.broken = false})
    d.map(x => println(x.toString))



    }



}