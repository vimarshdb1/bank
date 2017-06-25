package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.Ot;

/**
 * Servlet implementation class Otp
 */
@WebServlet("/Otp")
public class Otp extends HttpServlet {
     public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException{
	response.setContentType("text/html");  
	PrintWriter out = response.getWriter();
	String a=Otpgen.random(6);
    Ot.setotp(a);
	RequestDispatcher rd=request.getRequestDispatcher("Otp1.html"); 
	 rd.forward(request,response);
     }
}
