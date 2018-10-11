class Part(var broken: Boolean) {
//  val a = scala.util.Random
//  val b = a.nextInt(2)
//  val c = {
//    b match{
//      case 0 => true
//      case _ => false
//    }
//  }

  def this() = this(true)

  override def toString: String = "Is the part broken? " + broken
}
