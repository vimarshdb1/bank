package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Otp1
 */
@WebServlet("/Otp1")
public class Otp1 extends HttpServlet {
	 public void doPost(HttpServletRequest request, HttpServletResponse response)  
		        throws ServletException, IOException{
		 response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		String x = request.getParameter("otp");
		String e=utility.Ot.getotp();
		if(e.equals(x)) {
		RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");  
	        rd.forward(request,response);
	       }
		else
		{out.print("WRONG OTP,RETRY");
			RequestDispatcher rd=request.getRequestDispatcher("Otp1.html");
		rd.forward(request, response);}
		out.close();
	 }



}
