import odo.verte.{bean,seed}
import odo.verte.seed.User._
import odo.verte.seed.Stream._
object Main {

  def main(args: Array[String]): Unit = { 
    var user:bean.User = seed.User("Oleg",25,List("Olegatr","Great Olegan"))
    val string:String = user
    println(string)
    user = load(string)(classOf[bean.User])
    println(user)
  }
}