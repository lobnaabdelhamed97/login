package connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserImplementation implements UserInterface {

	

	static Connection conn;
	//The JDBC Statement, CallableStatement, and PreparedStatement interfaces define the methods and properties that enable you to send SQL commands 
	//and receive data from your database.
	//They also define methods that help bridge data type differences between Java and SQL data types used in a database.
	static PreparedStatement ps;
	
	static PreparedStatement departps;

	
	@Override
	public int insertUser(Users u) {
		int departmentid=0;
  // flag to check if there is a new user or not
		int status =0;
		try {
			//get the connection
			
			conn=ConnectionProvider.getConn();
			
			departps=conn.prepareStatement("select id from department where departname=?");
			departps.setString(1, u.getDepartment());
		
			ResultSet departrs = departps.executeQuery();
			while (departrs.next()) 
			{
				 departmentid=departrs.getInt("id");
				 
				}
			
		
			//inserting in db by the sql command in "" where the table name is users
ps=conn.prepareStatement("insert into users(name,password,birthdate,address,phone,email,departid) values(?,?,?,?,?,?,?)");
			//passing parameters

			ps.setString(1, u.getUsername());
			ps.setString(2,u.getPassword());
			ps.setDate(3, u.getDOB());
			ps.setString(4, u.getAddress());
			ps.setString(5,u.getContact());
			ps.setString(6, u.getEmail());
			ps.setInt(7, departmentid);
			status= ps.executeUpdate();
			conn.close();
			
			
		}catch (Exception e){
			System.out.println(e);
		}

		return status;
	}

	@Override
	public Users getUsers(String email, String password) {
       Users u = new Users();
       try {
    	 //get the connection
			conn=ConnectionProvider.getConn();
			//select the user from the db that matches the input  of user
			ps=conn.prepareStatement("select name from users where email=? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			
//			A ResultSet object maintains a cursor that points to the current
//			row in the result set. The term "result set" refers to the 
//			row and column data contained in a ResultSet object.

			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				u.setUsername(rs.getString(1));
			}
			
			//get time here 
			//insert into users (lastlogindate) values (the time we get)
       }catch (Exception e){
    	   
			System.out.println(e);
		}
		
		return u;
	}
	
	
}