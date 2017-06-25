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

@WebServlet("/transfer")
public class transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		String a = request.getParameter("am");
		String acc = request.getParameter("ac");
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
				String a1=String.valueOf(Integer.parseInt(b1)-Integer.parseInt(a));
		
				ps = con.prepareStatement("update user1 set bal=? where id=?");
					ps.setString(1, a1);
					ps.setString(2, id);
					ps.executeUpdate(); 
					PreparedStatement ps2;
					PreparedStatement ps3;
					  ps2=con.prepareStatement("select bal from user1 where id=?");
					    ps2.setString(1,acc);
						ResultSet rs1=ps2.executeQuery();
						rs1.next();
						String b2=rs1.getString(1);
						String a2=String.valueOf(Integer.parseInt(b2)+Integer.parseInt(a));
				
						ps3 = con.prepareStatement("update user1 set bal=? where id=?");
							ps3.setString(1, a2);
							ps3.setString(2, acc);
							ps3.executeUpdate(); 
					 out.print("TRANSACTION SUCCESS");
	            RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");  
		        rd.forward(request,response);
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
  
	


