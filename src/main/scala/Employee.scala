class Employee(val name:String, var time:Int) extends Person{
  def this(name:String) = this(name,0)
  override def toString()= "Name: %s, Time: %s" format (name, time)

}
