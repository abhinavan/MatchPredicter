package bean;

public class Match 
{
	private int number;
	private String match;
	private String date;
	
	public Match() 
	{
		
	}
	public Match(int number)
	{
		this.number=number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

}
