package util;

public class Person {
	
//	private final String id = "";
	private final String fname = "";
	private final String lname = "";
	private final String email = "";
	private final String state = "";
	
	public String getFName()
	{
		return fname;
	}
	
	public String getLName()
	{
		return lname;
	}
	
	public String getEmail()
	{
		return email;
	}
	
//	public String getId()
//	{
//		return id;
//	}
	
	public String getState()
	{
		return state;
	}
	
	public String toString()
	{
		return "First Name: " + fname + "Last Name: " + lname;
	}

}
