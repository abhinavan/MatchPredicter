package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface MatchDao 
{
	public List<String> getMatchByDate(String date) throws ClassNotFoundException,SQLException;

}
