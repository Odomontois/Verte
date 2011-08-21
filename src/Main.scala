import odo.verte.seed.User
import java.io.{StringReader}
//Main
object Main {

  def main(args: Array[String]): Unit = { 
    var user = User("Oleg",25,List("Olegatr","Great Olegan"))
    val string:String = user
    println(string)
    val reader = new StringReader(string)
    user = reader
    println(user)
  }
}