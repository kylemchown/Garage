class Employee(val name:String, var time:Int) extends Person{
  def this(name:String) = this(name,0)
}
