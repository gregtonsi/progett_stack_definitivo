package progetto;
public class StackException extends Exception 
{
	private String messaggio;
	public StackException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	public String toString()
	{
		return messaggio;
	}
}
