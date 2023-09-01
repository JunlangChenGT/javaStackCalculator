package h08;

public class FullStackException extends RuntimeException
{
//no args constructor
	public FullStackException()
	{
		super();
	}
	
	//String arg constructor
	public FullStackException(String error)
	{
		super(error);
	}
}
