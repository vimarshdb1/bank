package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class password extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
	String pass1 = request.getParameter("pass");
	String pass2 = request.getParameter("pass1");
	String pass3 = request.getParameter("pass2");
	String id=utility.Dao.getId();
		
		 if(LoginDao.validate(id, pass1)){
			 if(pass2.equals(pass3)){
			 try{Connection con = utility.Dao.getConnection();
			PreparedStatement ps;
			
				ps = con.prepareStatement("update user1 set pass=? where id=?");
				ps.setString(1, pass2);	
				ps.setString(2, id);
					ps.executeUpdate(); 
					 out.print("ACCOUNT DELETED");
	            RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");  
		        rd.forward(request,response);
			 }catch(Exception e2){out.println(e2);}
			 
			 }else{out.print("PASSWORD DO NOT MATCH");
			 }
		    }  
		    else{  
		        out.print("Sorry password error,Please Re-Enter");  
		        RequestDispatcher rd=request.getRequestDispatcher("changePassword.html");  
		        rd.include(request,response);  
		    }  
		      out.close();  
	}
	}

