package odo.verte.seed

import org.codehaus.jackson.map.ObjectMapper
import java.io.{Reader, Writer, StringWriter }
object Stream{
  lazy val mapper = new ObjectMapper
  implicit def load[T](source :String)(implicit beanClass:Class[T]):T =   mapper.readValue(source,beanClass)
  def load[T](source:Reader)( implicit beanClass: Class[T]):T = mapper.readValue(source,beanClass)
  implicit def save[T](value:T): String = {
    val stream = new StringWriter
    save[T](value,stream)
    stream.toString()
  }
  def save[T](value:T, writer:Writer) =  mapper.writeValue(writer,value)  
}