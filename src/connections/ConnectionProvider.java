package connections;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionProvider implements  MyProvider{
		static Connection conn= null;
		
		public static Connection getConn(){
			
			try{
				//my connection driver
				Class.forName("com.mysql.jdbc.Driver");
				//get the connection 
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root", "lobna1997");
			if(conn!=null)
				System.out.print("connection success");
			}
			
			catch (Exception e){
				System.out.println("connection unsuccessful");
				e.printStackTrace();
			}
			
			return conn ;
			}
		}

		
		

