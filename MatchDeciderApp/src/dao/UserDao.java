package dao;

import java.sql.SQLException;

public interface UserDao 
{
	boolean validateUser(String uname , String password) throws ClassNotFoundException, SQLException;
	StringBuilder validatePassword(String password,String cpassword);
	boolean matchUserName(String uname) throws ClassNotFoundException,SQLException;
	boolean matchEmail(String email) throws SQLException;
	int insertUser(String fname,String lname,String uname,String email,String password) throws ClassNotFoundException,SQLException;
}
