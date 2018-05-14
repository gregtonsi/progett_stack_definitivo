package progetto;

public class FileException extends Exception 
{
	public String message;
	public FileException(String message)
	{
		this.message=message;
	}
	public String toString()
	{
		return message;
	}
}
