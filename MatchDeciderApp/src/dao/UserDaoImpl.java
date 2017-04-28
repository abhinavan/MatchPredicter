package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import connectionUtils.MyConnection;

public class UserDaoImpl implements UserDao
{
	
	Connection con;
	PreparedStatement ps1, ps2;
	ResultSet rs1,rs2;
	public UserDaoImpl() 
	{
		try 
		{
			con=new MyConnection().getConnection();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
	}
	public boolean validateUser(String uname , String password) throws ClassNotFoundException, SQLException
	{
		Connection con=new MyConnection().getConnection();
		if(con!=null)
		{
			PreparedStatement ps=con.prepareStatement("select * from IPLuser where uname=? and password=?");
			ps.setString(1,uname);
			ps.setString(2,password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				
				return true;
			}
		}
		return false;
	}

	@Override
	public StringBuilder validatePassword(String password, String cpassword) 
	{
		StringBuilder retVal=new StringBuilder();
		
		if(password.length()>=7 && cpassword.length()>=7)
		{
			if(Pattern.matches(".*\\d.*", password));
			{
				retVal.append("password contain at least one number");
				return retVal;
			}
			
		
		}
		else
		{
			retVal.append("Password must be of minimum 7 characters");
			return retVal;
		}
		
	}

	public boolean matchUserName(String uname) throws SQLException
	{
		boolean flag=false;
		ps1=con.prepareStatement("select uname from ipluser where uname=?");
		ps1.setString(1,uname);
		rs1=ps1.executeQuery();
		if(rs1.next())
		{
			flag=true;
			return flag;
		}
		return false;
	}

	@Override
	public boolean matchEmail(String email) throws SQLException
	{
		boolean flag=false;
		ps2=con.prepareStatement("select email from ipluser where email=?");
		ps2.setString(1,email);
		rs2=ps2.executeQuery();
		
		if(rs2.next())
		{
			flag=true;
			return flag;
		}
		return false;
	}
	@Override
	public int insertUser(String fname, String lname, String uname, String email, String password)
			throws ClassNotFoundException, SQLException 
	{
		ps1=con.prepareStatement("insert into ipluser(?,?,?,?,?) values(?,?,?,?,?)");
		ps1.setString(1,"fname");
		ps1.setString(2,"lname");
		ps1.setString(3,"uname");
		ps1.setString(4,"email");
		ps1.setString(5,"pass");
		
		ps1.setString(1,fname);
		ps1.setString(2,lname);
		ps1.setString(3,uname);
		ps1.setString(4,email);
		ps1.setString(5,password);
		
		int status=ps1.executeUpdate();
		System.out.println(status);
		return status;
	}

}
