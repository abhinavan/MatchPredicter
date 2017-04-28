package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Match;
import connectionUtils.MyConnection;

public class MatchDaoImpl implements MatchDao
{
	public List<String> getMatchByDate(String date) throws ClassNotFoundException ,SQLException
	{
		Connection con=new MyConnection().getConnection();
		PreparedStatement ps=con.prepareStatement("select * from matchTable where dom=?");
		ps.setString(1,date);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString("match"));
		}
		return null;
	}

}
