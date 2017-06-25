package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class withdraw extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		String a = request.getParameter("am");
		String pass1 = request.getParameter("pass");
	    String id=utility.Dao.getId();
		
		 if(LoginDao.validate(id, pass1)){  
			 try{Connection con = utility.Dao.getConnection();
			PreparedStatement ps;
			PreparedStatement ps1;
			
			    ps1=con.prepareStatement("select bal from user1 where id=?");
			    ps1.setString(1,id);
				ResultSet rs=ps1.executeQuery();
				rs.next();
				String b1=rs.getString(1);
				if(b1.equals("0"))
				{out.print("No Balance");
				}
				else
				{
				String a1=String.valueOf(Integer.parseInt(b1)-Integer.parseInt(a));
		
				ps = con.prepareStatement("update user1 set bal=? where id=?");
					ps.setString(1, a1);
					ps.setString(2, id);
					ps.executeUpdate(); 
					 out.print("TRANSACTION SUCCESS");
	            RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");  
		        rd.forward(request,response);
				}
				
				
				
			 }catch(Exception e2){out.println(e2);}
		    }  
		    else{  
		        out.print("Sorry password error,Please Re-Enter");  
		        RequestDispatcher rd=request.getRequestDispatcher("withdraw.html");  
		        rd.include(request,response);  
		    }  
		      out.close();  
		
	}

}
