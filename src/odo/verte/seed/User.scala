package odo.verte.seed
import odo.verte.{ bean, seed }
import scala.collection.JavaConversions._
import scala.collection.mutable.Buffer

case class User(name: String, age: Int, otherNames: List[String])
object User {
  implicit def userBeanToSeed(user: bean.User): seed.User =
    User(user.getName,
      user.getAge,
      asBuffer(user.getOtherNames).toList)
  implicit def userSeedToBean(user: User): bean.User = {
    val userBean = new bean.User
    userBean.setName(user.name)
    userBean.setAge(user.age)
    userBean.setOtherNames(asJavaList(user.otherNames))
    userBean
  }
}