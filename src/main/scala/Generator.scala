object Generator {
  def partArray()={
    val d = Array.fill(scala.util.Random.nextInt(10)+10){new Part()}
    d.map(x => if(scala.util.Random.nextInt(2) == 0){x.broken = false})
    d
  }

  def makeCar()={
    val wheels = scala.util.Random.nextInt(2)+3
    val doors = scala.util.Random.nextInt(2)+3
    val id = scala.util.Random.nextInt(5000)
    val model = scala.util.Random.alphanumeric.take(5).mkString
    val parts = partArray()
    new Car(wheels, id, doors, model, parts)
  }
}
