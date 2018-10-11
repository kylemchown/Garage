object Runner {

  def main(args: Array[String]) {

    val a = new Car(4, 123, 2, "AB-142")
    println(a.toString)
    val b = new Bike(2, 2345)
    println(b.toString)
    var c: scala.collection.mutable.ArrayBuffer[Vehicle]=scala.collection.mutable.ArrayBuffer.empty[Vehicle]
    println(c)
  }
}