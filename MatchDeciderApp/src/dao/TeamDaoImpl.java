package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectionUtils.MyConnection;

public class TeamDaoImpl implements TeamDao  
{

	int status=0,fratings=0,sratings=0;
	public Connection con;
	public PreparedStatement ps1,ps2,ps3,ps4;
	public ResultSet rs1,rs2,rs3,rs4;
	public  TeamDaoImpl() throws SQLException 
	{
		con=new MyConnection().getConnection();
	}
	@Override
	public int validateTeam(String fteam, String steam,String stadium) throws ClassNotFoundException, SQLException
	{
		// finding first team in database
		ps1=con.prepareStatement("select * from teamInformation where teamName=?");
		ps1.setString(1,fteam);
		rs1=ps1.executeQuery();
		
		// finding second team in database 
		ps2=con.prepareStatement("select * from teamInformation where teamName=?");
		ps2.setString(1,steam);
		rs2=ps2.executeQuery();
		
		if(rs1.next() && rs2.next())
		{
			if(stadium.equals(rs1.getString("teamStadium")))
			{
				status=1;
				
			}
			else if(stadium.equals(rs2.getString("teamStadium")))
			{
				status=2;
			}
			else
			{
				status=3;
			}
			return status;
		}
		
		
		return status;
	}

	
	@Override
	public String startPrediction(String fteam, String steam, String stadium,int status)
			throws ClassNotFoundException, SQLException 
	{
		String winningTeam;
		// finding power ratings of first team
		ps1=con.prepareStatement("select sum(playerRatings)'powerRatings' from playerTable where playerTeam=?");
		ps1.setString(1,fteam);
		rs1=ps1.executeQuery();
		if(rs1.next())
		{
			fratings=rs1.getInt("powerRatings");
		}
		// finding power ratings of second team 
		ps2=con.prepareStatement("select sum(playerRatings)'powerRatings' from playerTable where playerTeam=?");
		ps2.setString(1,steam);
		rs2=ps2.executeQuery();
		if(rs2.next())
		{
			sratings=rs2.getInt("powerRatings");
		}
		
		// finding power ratings of allrounder of first team
		ps3=con.prepareStatement("select sum(playerRatings)'powerRatings' from playerTable where playerTeam=? and playerRole=?");
		ps3.setString(1,fteam);
		ps3.setString(2,"allrounder");
		rs3=ps3.executeQuery();
		
		//finding power ratings of allrounder of second team
		ps4=con.prepareStatement("select sum(playerRatings)'powerRatings' from playerTable where playerTeam=? and playerRole=?");
		ps4.setString(1,steam);
		ps4.setString(2,"allrounder");
		rs4=ps4.executeQuery();
		
		if(status==1)
		{
			if(fratings-sratings>=5)
			{
				System.out.println(fteam+" will win");
				winningTeam=fteam;
				return winningTeam;
			}
			else if (fratings-sratings<5 && fratings-sratings>=-5)
			{
				// getting power Ratings of allrounder of both team
				if(rs3.next() && rs4.next())
				{
					fratings=rs3.getInt("powerRatings");
					sratings=rs4.getInt("powerRatings");			
				}
				
				if(fratings-sratings>=0)
				{
					System.out.println(fteam+" will win narrowely");
					winningTeam=fteam;
					return winningTeam;
				}
				else
				{
					System.out.println(steam+" will win away match");
					return steam;
				}
			}
			else
			{
				System.out.println(steam+" will win for sure");
				winningTeam=steam;
				return winningTeam;
			}
			
		}
		else if (status==2)
		{
			if(sratings-fratings>=5)
			{
				System.out.println(steam+" will win in their stadium");
				winningTeam=steam;
				return winningTeam;
			}
			else if (sratings-fratings<5 && sratings-fratings>=-5)
			{
				
				// getting power ratings of all rounder from both teams 
				if(rs3.next() && rs4.next())
				{
					fratings=rs3.getInt("powerRatings");
					sratings=rs4.getInt("powerRatings");
				}
				if(sratings-fratings>=0)
				{
					System.out.println(steam+" will win anyhow");
					winningTeam=steam;
					return winningTeam;
				}
				else
				{
					System.out.println(fteam+" will win somehow");
					winningTeam=fteam;
					return winningTeam;
					
				}
				
			}
			else
			{
				System.out.println(fteam+" will win at last");
				winningTeam=fteam;
				return winningTeam;
			}
			
		}
		// logic for status==3 is pending 
		else
		{
			return null;
		}
		
	}

	@Override
	public String findStadium(String stadium) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
