package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
	String pass1 = request.getParameter("pass");
	    String id=utility.Dao.getId();
		
		 if(LoginDao.validate(id, pass1)){  
			 try{Connection con = utility.Dao.getConnection();
			PreparedStatement ps;
			
				ps = con.prepareStatement("delete from user1 where id=?");
					ps.setString(1, id);
					ps.executeUpdate(); 
					 out.print("ACCOUNT DELETED");
	            RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");  
		        rd.forward(request,response);
			 }catch(Exception e2){out.println(e2);}
		    }  
		    else{  
		        out.print("Sorry password error,Please Re-Enter");  
		        RequestDispatcher rd=request.getRequestDispatcher("deleteUser.html");  
		        rd.include(request,response);  
		    }  
		      out.close();  
	}

}
