package user;
import java.sql.*;  
	  
	public class LoginDao {  
	public static boolean validate(String name,String pass){  
	boolean status=false;  
	try{  
		
		Connection con = null;
	con = utility.Dao.getConnection();
	PreparedStatement ps=con.prepareStatement(  
	"select * from user1 where id=? and pass=?");  
	ps.setString(1,name);  
	ps.setString(2,pass);  
	      
	ResultSet rs=ps.executeQuery();  
	status=rs.next();  
	          
	}catch(Exception e){System.out.println(e);}  
	return status;  
	}  
}  

