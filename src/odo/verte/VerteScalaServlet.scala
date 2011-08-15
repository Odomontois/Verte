package odo.verte

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class VerteScalaServlet extends HttpServlet {
	override def doGet(req : HttpServletRequest, resp: HttpServletResponse) = 
	  resp.getWriter.println("Greeting, gentleman!")
}