package progetto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile 
{
	private char mode;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	public TextFile(String fileName, char mode) throws IOException
	{
		this.mode='R';
		if(mode=='W'||mode=='w')
		{
			FileWriter scrivi=new FileWriter(fileName);
			writer=new BufferedWriter(scrivi);
			this.mode='W';
		}
		if(mode=='r'||mode=='R')
		{
			FileReader leggi=new FileReader(fileName);
			reader=new BufferedReader(leggi);
		}
	}
		public void toFile(String line) throws FileException, IOException
		{
			if(mode=='R')
				throw new FileException("File aperto in lettura");
			writer.write(line);
			writer.newLine();
		}
		public String fromFile() throws FileException, IOException
		{
			String rigaLetta;
			if(mode=='W')
				throw new FileException("file aperto in scrittura");
			rigaLetta=reader.readLine();
			if(rigaLetta==null)
			{
				throw new FileException("end of file");
			}
			return rigaLetta;
		}
		public void closeFile() throws IOException
		{
			if(mode=='R')
				reader.close();
			else 
				writer.close();
		}
	
}
