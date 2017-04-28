package connectionUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection 
{
	public Connection con;
	public MyConnection() 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.getMessage();
		}
	}
	
	public Connection getConnection() throws SQLException
	{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
		return con;
	}

}
