package progetto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * 
 * @author gregtonsi:
 * Classe che crea e gestisce una lista di tipo stack formata da oggetti instanziati dalla classe "Metodo", è possibile quindi inserire o eliminare solo in testa alla lista
 */
public class Stack implements Serializable 
{ 
	private Nodo head;
	private int elementi;
	/**
	 * Per istanziare un nuovo oggetto di tipo stack
	 */
	public Stack()
	{
		head=null;
		elementi=0;
	}
	/**
	 * 
	 * @return numero metodi nella lista
	 */
	public int getElementi()
	{
		return elementi;
	}
	/**
	 * Crea un nuovo nodo
	 * @param metodo
	 * @param link
	 * @return nodo creato
	 */
	public Nodo creaNodo(Metodo metodo, Nodo link)
	{
		Nodo nodo=new Nodo(metodo);
		nodo.setLink(link);
		return nodo;
	}
	/**
	 * Restituisce il nodo nella posizione inserita come parametro
	 * @param posizione
	 * @return nodo nella posizione indicata come parametro
	 * @throws StackException
	 */
	private Nodo getLinkPosizione(int posizione) throws StackException
	{
		if(posizione<1 || posizione>getElementi())
			throw new StackException("posizione non valida");
		if(elementi==0)
			throw new StackException("lista vuota");
		Nodo p;
		int n;
		p=head;
		n=1;
		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();
			n++;
		}
		return p;
	}
	/**
	 * Permette di inserire in cima alla pila un metodo
	 * @param metodo
	 */
	public void push(Metodo metodo)
	{
		Nodo p=creaNodo(metodo,head);
		head=p;
		elementi++;
	}
	/**
	 * Restituisce una stringa che contiene i l'elenco dei metodi presenti nella lista
	 * @return Stringa  dei metodi presenti nello stack
	 */
	public String toString()
	{
		String risultato="Head-->";
		if (elementi==0)
			return risultato;
		
		Nodo p=head;
		while(p!=null)
		{
			risultato+=p.getInfo().getNome().toString()+";";
			p=p.getLink();
		}
		return risultato;
	}
	/**
	 * Permette di eseguire ed in seguito eliminare dalla lista il metodo in testa alla lista
	 * @return il metodo che verrà eseguito e quindi eliminato dallo stack
	 * @throws StackException
	 */
	public Metodo pop() throws StackException
	{
		
		if(elementi==0)
			throw new StackException("lista vuota");
		Nodo p=head;
		head=head.getLink();
		elementi--;
		return p.getInfo();
	}
	/**
	 * Metodo che salva uno stack su un file di testo in formato CSV 
	 * @throws FileException
	 * @throws IOException
	 * @throws StackException
	 */
	public void salvaCSV() throws FileException, IOException, StackException
	{
		if(elementi==0)
			throw new StackException("lista vuota");
		String nomeFile=getNomeTXT();
		TextFile Txt=new TextFile(nomeFile,'W');
		String salva;
		Nodo n;
		for (int i = 1; i <= elementi; i++) 
		{
			n=getLinkPosizione(i);
			salva=n.getInfo().getNome()+";"+n.getInfo().getClasseAppartenenza()+";"+n.getInfo().getIndirizzoRitornoEsa()+";"+n.getInfo().getNumeroParametri()+";"+n.getInfo().getValoreRitorno()+";";
			for (int j = 0; j < n.getInfo().getNumeroParametri(); j++) 
			{
				salva=salva+n.getInfo().getElencoParametri()[j]+";";
			}
			Txt.toFile(salva);
		}
		Txt.closeFile();
	}
	/**
	 * Genera e restituisce il percorso di un fie txt che sarà creato er il salvataggio dello stack in CSV
	 * @return stringa che contiene il percorso di un nuovo file txt con nome "log_data_ora"
	 */
	public String getNomeTXT()
	{
		LocalDateTime data=LocalDateTime.now();
		return  "log\\log_"+data.getDayOfMonth()+"_"+data.getMonthValue()+"_"+data.getYear()+"_"+data.getHour()+"_"+data.getMinute()+"_"+data.getSecond()+".txt";
	}
	/**
	 * Converte la lista dei metodi dello stack in un array di metodi 
	 * @return array di metodi
	 * @throws StackException
	 */
	public Metodo[] convertiStack() throws StackException
	{
		Nodo n;
		Metodo[] arrayMetodi=new Metodo[elementi];
		for (int i = 0; i < elementi; i++) 
		{
			n=getLinkPosizione(i+1);
			arrayMetodi[i]=n.getInfo();
		}
		return arrayMetodi;
	}
	/**
	 * Converte un array di metodi in uno stack, salvandolo nello stesso stack che lo invoca 
	 * @param metodo
	 */
	public void convertiMetodo(Metodo[] metodo)
	{
		for (int i = metodo.length; i >0; i--) 
		{
			push(metodo[i-1]);
		}
	}
	/**
	 * Scambia di posizione due metodi presenti in un array di metodi
	 * @param array
	 * @param pos1
	 * @param pos2
	 * @return valore intero che può essere -1,se la posizione inserita non e' valida, o 0 se l'operazione e' andata a buon fine
	 */
	public static int scambia (Metodo[] array, int pos1, int pos2)
	{
		Metodo s;
		if (pos1<0 || pos2<0 || pos1>=array.length || pos2>=array.length)
			return -1;
		else
		{
			s=array[pos1];
			array[pos1]=array[pos2];
			array[pos2]=s;
			return 0;
		}			
	}
	/**
	 * Crea una copia di un array di metodi
	 * @param array
	 * @return array di metodi
	 */
	private static Metodo[] copiaArray(Metodo[] array)
	{
		Metodo[] arrayCopia=new Metodo[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
			arrayCopia[i]=array[i];
		return arrayCopia;
	}
	/**
	 * Ricevendo un array di metodi ne crea uno nuovo in ordine crescente
	 * @param array
	 * @return array di metodi ordinato in ordine crescente
	 */
	public static Metodo[] selectionSortCrescente(Metodo[] array)
	{
		Metodo[] arrayCopia=copiaArray(array);
		
		for (int i = 0; i < arrayCopia.length-1; i++) 
		{
			
			for (int j = i+1; j < arrayCopia.length; j++) 
			{
				if (arrayCopia[i].getNome().compareToIgnoreCase(arrayCopia[j].getNome())>0)
					scambia(arrayCopia,i,j);
			}
		}
		return arrayCopia;
	
	}
	/**
	 * Si occupa di serializzare lo stack in esecuzione su un file di tipo .bin
	 * @param nomeFile
	 * @throws IOException
	 */
	public void serializzazione(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	/**
	 * Si occupa di deserializzare uno stack da un file .bin
	 * @param nomeFile
	 * @return stack deserializzato
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Stack deserializzazione (String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		Stack stack=(Stack)(reader.readObject());
		file.close();
		return stack;
	}
	/**
	 * Genera e restituisce il percorso di un fie bin che sarà creato per il salvataggio dello stack
	 * @return stringa che contiene il percorso di un nuovo file txt con nome "data_ora"
	 */
	public String getNomeBIN() 
	{
		LocalDateTime data=LocalDateTime.now();
		return "stack\\"+data.getDayOfMonth()+"_"+data.getMonthValue()+"_"+data.getYear()+"_"+data.getHour()+"_"+data.getMinute()+"_"+data.getSecond()+".bin";
	}
	/**
	 * Mostra i possibili file da cui caricare uno stack e permette di sceglierlo,restituendone il nome
	 * @return nome file dello stack da caricare
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws StackException
	 */
	public String percorsoStack() throws NumberFormatException, IOException, StackException
	{
		ConsoleInput scelta=new ConsoleInput();
		File dir = new File("stack\\");
		File[] files = dir.listFiles();
		if(files==null)
		{
			throw new StackException("non sono presenti salvataggi");
		}
		System.out.println("digita stack da caricare:");
			for (int i = 0; i < files.length; i++)
			{
				System.out.println((i+1)+"-->"+files[i]);
			}
			int stackDigit=0;
			try
			{
				stackDigit=scelta.readInt();
				if(files.length<stackDigit)
				throw new StackException("errore inserimento scelta...");
			}
			catch(NumberFormatException e)
			{
				throw new StackException("errore inserimento scelta...");
			}
			return files[stackDigit-1].getName();
	}
	
}
