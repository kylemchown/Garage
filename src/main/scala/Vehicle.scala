abstract class Vehicle {
  val wheels: Int
  val id: Int
  val parts: Array[Part]
  var timeStart: Int
  var timeEnd: Int
  var servedBy: String
  override def toString: String ={
    var noBroken = 0
    parts.map(x=> if(x.broken){noBroken+=1})
    "ID: %s, Wheels: %s, No. Broken: %s, Start: %s, End: %s, Served By: %s" format (id, wheels, noBroken, timeStart, timeEnd, servedBy)
  }

}
