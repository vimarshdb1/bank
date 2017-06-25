package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.datedifference;

/**
 * Servlet implementation class dated
 */
@WebServlet("/dated")
public class dated extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ PrintWriter out = response.getWriter(); 
		response.setContentType("text/html");
	String day1=request.getParameter("day");
    String mon1=request.getParameter("mon");
	String year1=request.getParameter("year");
	String hr1=request.getParameter("hour");
	String min1=request.getParameter("min");
	String sec1=request.getParameter("sec");
	String day2=request.getParameter("day1");
	String mon2=request.getParameter("mon1");
	String year2=request.getParameter("year1");
	String hr2=request.getParameter("hour1");
	String min2=request.getParameter("min1");
	String sec2=request.getParameter("sec1");
	String d1=mon1+"/"+day1+"/"+year1+" "+hr1+":"+min1+":"+sec1 ;
	String d2=mon2+"/"+day2+"/"+year2+" "+hr2+":"+min2+":"+sec2 ;
	datedifference a1 = new datedifference();
	a1=a1.diff(d1, d2);
	out.print(a1.s1+" Seconds "+a1.m1+" Minutes "+a1.h1+" Hours "+a1.day1+" Days ");
	}

}
