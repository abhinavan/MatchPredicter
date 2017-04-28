package bean;

public class User 
{
	private String uname;
	private String password;
	private int id;
	private int winnings;
	public User() 
	{
	
	}
	public User(int id)
	{
		this.id=id;
	}
	
	public String getUname() 
	{
		return uname;
	}
	public void setUname(String uname) 
	{
		this.uname = uname;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public int getWinnings() 
	{
		return winnings;
	}
	public void setWinnings(int winnings) 
	{
		this.winnings = winnings;
	}
	
	@Override
	public String toString() 
	{
	
		return uname+" "+id+" "+winnings;
	}
	
}
