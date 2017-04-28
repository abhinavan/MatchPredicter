package dao;

import java.sql.SQLException;

public interface TeamDao 
{
	int validateTeam(String fteam,String steam,String stadium) throws ClassNotFoundException, SQLException;
	String startPrediction(String homeTeam,String awayTeam,String stadium,int status) throws ClassNotFoundException,SQLException;
	String findStadium(String stadium) throws ClassNotFoundException,SQLException;
}
