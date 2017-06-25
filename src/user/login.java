package user;

	import java.io.IOException;  

	import java.io.PrintWriter;  
	  
	import javax.servlet.RequestDispatcher;  
	import javax.servlet.ServletException;  
	import javax.servlet.http.HttpServlet;  
	import javax.servlet.http.HttpServletRequest;  
	import javax.servlet.http.HttpServletResponse;  
	  
	public class login extends HttpServlet {  
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	 response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	   String n=request.getParameter("id");  
	    String p=request.getParameter("pass");  
	 if(LoginDao.validate(n, p)){  
	    	out.print("LOGGED IN");
	        RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");  
	        rd.forward(request,response);
	        utility.Dao.setId(n);
	    }  
	    else{  
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request,response);  
	    }  
	      out.close();  
	    }

	
		
}

	