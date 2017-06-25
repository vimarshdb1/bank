package user;
import java.io.*;  
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class register extends HttpServlet {  

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
			response.setContentType("text/html");  
			PrintWriter out = response.getWriter();  
		String e = request.getParameter("name");
		String n = request.getParameter("id");
		String a = request.getParameter("add");
		String m = request.getParameter("mob");
		String d = request.getParameter("day");
		String mo = request.getParameter("mon");
		String y=request.getParameter("year"); 
			String p=request.getParameter("pass"); 
			String q=request.getParameter("pass1");  
			String date= y+":"+mo+":"+d;
			
			
			
			if(p.equals(q))
			{
			          
			try{  
				
				Connection con=utility.Dao.getConnection(); 
			  
			PreparedStatement ps=con.prepareStatement(  
			"insert into user1 values(?,?,?,?,?,?,?)");  
			  
			ps.setString(1,n);  
			ps.setString(2,e);  
			ps.setString(3,a);  
			ps.setString(4,m);  
			ps.setString(5,p);
			ps.setString(6,date);
			ps.setString(7,"0");
			          
			int i=ps.executeUpdate();  
			if(i>0)  
			{
			RequestDispatcher rd=request.getRequestDispatcher("success.html");  
	        rd.forward(request,response);		}     
			          
			}catch (Exception e2) {System.out.println(e2);}  
			}
			else
				out.print("WRONG PASSWORD");
			out.close();  
			}  
			  
}  