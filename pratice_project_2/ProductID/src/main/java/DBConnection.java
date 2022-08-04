import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static Connection con=null;
	public static Connection getMyConnection() {
		// TODO Auto-generated method stub
		try {
			//step1 load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step2 create the connection object
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","12345");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}

	}

