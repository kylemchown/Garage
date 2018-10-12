object Generator {
  def partArray(a: Int): Array[Part] ={
    val d = Array.fill(scala.util.Random.nextInt(a)+5){new Part()}
    d.map(x => if(scala.util.Random.nextInt(2) == 0){x.broken = false})
    d
  }

  def makeCar(): Car ={
    val wheels = scala.util.Random.nextInt(2)+3
    val doors = scala.util.Random.nextInt(2)+3
    val id = scala.util.Random.nextInt(5000)
    val model = scala.util.Random.alphanumeric.take(5).mkString
    val parts = partArray(15)
    new Car(wheels, id, doors, model, parts)
  }

  def makeBike(): Bike ={
    val wheels = scala.util.Random.nextInt(2)+3
    val doors = scala.util.Random.nextInt(2)+3
    val parts = partArray(10)
    new Bike(wheels,doors,parts)
  }

}
