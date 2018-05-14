package progetto;
import java.io.IOException;
import java.io.Serializable;
/**
 * @author gregtonsi:
 * classe che crea e gestisce oggetti di tipo metodo
 */
public class Metodo implements Serializable 
{
	private String nome;
	private String classeAppartenenza;
	private int numeroParametri;
	private String[] elencoParametri;
	private String valoreRitorno;
	private String indirizzoRitornoEsa;
	/**
	 * consente di istanziare un metodo
	 */
	public Metodo()
	{
		
	}
	/**
	 * Restituisce l'indirizzo di ritorno in esadecimale
	 * @return indirizzo di ritorno in esadecimale
	 */
	public String getIndirizzoRitornoEsa() 
	{
		return indirizzoRitornoEsa;
	}
	/**
	 * Imposta l'indirizzo di ritorno in esadecimale
	 * @param indirizzoRitornoEsa
	 */
	public void setIndirizzoRitornoEsa(String indirizzoRitornoEsa) 
	{
		
		this.indirizzoRitornoEsa = indirizzoRitornoEsa;
	}
	/**
	 * Restituisce la stringa del valore di ritorno
	 * @return stringa del valore di ritorno
	 */
	public String getValoreRitorno() 
	{
		return valoreRitorno;
	}
	/**
	 * Imposta il valore di ritorno
	 * @param valoreRitorno
	 */
	public void setValoreRitorno(String valoreRitorno) 
	{
		this.valoreRitorno = valoreRitorno;
	}
	/**
	 * Restituisce il numero di parametri del metodo
	 * @return numero di parametri del metodo
	 */
	public int getNumeroParametri() 
	{
		return numeroParametri;
	}
	/**
	 * Imposta il numero di parametri del metodo
	 * @param numeroParametri
	 */
	public void setNumeroParametri(int numeroParametri) 
	{
		this.numeroParametri = numeroParametri;
	}
	/**
	 * Restituisce la classe di appartenenza del metodo
	 * @return classe di appartenenza del metodo
	 */
	public String getClasseAppartenenza() 
	{
		return classeAppartenenza;
	}
	/**
	 * Imposta la classe di appartenenza del metodo
	 * @param classeAppartenenza
	 */
	public void setClasseAppartenenza(String classeAppartenenza) 
	{
		this.classeAppartenenza = classeAppartenenza;
	}
	/**
	 * Restituisce il nome del metodo
	 * @return nome metodo
	 */
	public String getNome() 
	{
		return nome;
	}
	/**
	 * Imposta il nome del metodo
	 * @param nome
	 */
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	/**
	 * Permette l'inserimento dei dati di un nuovo metodo da tastiera
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws numberException 
	 */
	public void inserisciMetodo() throws NumberFormatException, IOException
	{
		ConsoleInput reader=new ConsoleInput();
		System.out.println("nuovo metodo...\ninserire nome metodo:");
		nome=reader.readString();
		if(checkNumber(nome)==false)
		{
			if(possibileErrore()==false)
			{
				do
				{
					System.out.println("reinserisci dato...");
					nome=reader.readString();
				}while(checkNumber(nome)==false);
			}
		}
		while(checkString(nome)==false)
		{
			System.out.println("errore,reinserire il nome del metodo...");
			nome=reader.readString();
		}
		System.out.println("inserire la classe a cui appartiene:");
		classeAppartenenza=reader.readString();
		if(checkNumber(classeAppartenenza)==false)
		{
			if(possibileErrore()==false)
			{
				do
				{
					System.out.println("reinserisci dato...");
					classeAppartenenza=reader.readString();
				}while(checkNumber(classeAppartenenza)==false);
			}
		}
		while(checkString(classeAppartenenza)==false)
		{
			System.out.println("errore,reinserire la classe di appartenenza del metodo...");
			classeAppartenenza=reader.readString();
		}
		System.out.println("inserire tipo di ritorno del metodo:");
		valoreRitorno=reader.readString();
		while(checkTypeReturn(valoreRitorno)==false)
		{
			System.out.println("errore,reinserire il tipo di ritorno del metodo...");
			valoreRitorno=reader.readString();
		}
		System.out.println("inserire l'indirizzo di ritorno in esadecimale del metodo:");
		indirizzoRitornoEsa=reader.readString();
		while(checkStringEsa(indirizzoRitornoEsa)==false)
		{
			System.out.println("errore,reinserire l'indirizzo di ritorno in esadecimale del metodo...");
			indirizzoRitornoEsa=reader.readString();
		}
		boolean corretto=true;
		do
		{
			int messaggio=0;
			corretto=true;
			try
			{
				System.out.println("inserire il numero di parametri(massimo 9 parametri):");
				numeroParametri=reader.readInt();
				if(numeroParametri>9)
					do
					{
						System.out.println("errore inserimento,reinserire il numero di parametri(massimo 9 parametri)...");
						numeroParametri=reader.readInt();
					}while(numeroParametri>9 );
			}
			
			catch(NumberFormatException e)
			{
				System.out.println("errore inserimento numero di parametri...");
				corretto=false;
				messaggio=1;
			}
			try
			{
			elencoParametri=new String[numeroParametri]; 
			}catch(NegativeArraySizeException e)
			{
				if(messaggio!=1)
				{
				System.out.println("errore inserimento numero di parametri...");
				}
				corretto=false;
			}
		}while(corretto==false);
		for (int j = 0; j < numeroParametri; j++) 
		{
			System.out.println("inserire il parametro "+(j+1)+":");
			elencoParametri[j]=reader.readString();
			if(checkNumber(elencoParametri[j])==false)
			{
				if(possibileErrore()==false)
				{
					do
					{
						System.out.println("reinserisci dato...");
						elencoParametri[j]=reader.readString();
					}while(checkNumber(elencoParametri[j])==false);
				}
			}
			while(checkString(elencoParametri[j])==false)
			{
				System.out.println("errore,reinserire parametro...");
				elencoParametri[j]=reader.readString();
				if(checkNumber(elencoParametri[j])==false)
				{
					if(possibileErrore()==false)
					{
						do
						{
							System.out.println("reinserisci dato...");
							elencoParametri[j]=reader.readString();
						}while(checkNumber(elencoParametri[j])==false);
					}
				}
			}
		}	
	}
	
	/**
	 * Controllo sull'inserimento corretto del "tipo di ritorno" del metodo 
	 * @param typeReturn
	 * @return vero se l'inserimento e' corretto,falso se l'inserimento e' errato
	 */
	public boolean checkTypeReturn(String typeReturn) 
	{
		String[] tipi= {"int","String","char","long","short","boolean","float","double","byte"};
		for (int i = 0; i < tipi.length; i++) 
		{
			if(typeReturn.compareToIgnoreCase(tipi[i])==0)
				return true;
		}
		return false;
	}
	/**
	 * consente la visualizzazione del metodo e delle sue specifiche(nome,classe di appartenenza,tipo di restituzione, numero di parametri e il nome di questi parametri)
	 */
	public void visualizzaMetodo()
	{
		System.out.println("Nome metodo:"+getNome());
		System.out.println("Classe di appartenenza:"+getClasseAppartenenza());
		System.out.println("Indirizzo di ritorno metodo:"+getIndirizzoRitornoEsa());
		System.out.println("Tipo di valore di ritorno:"+getValoreRitorno());
		System.out.println("Numero di parametri:"+getNumeroParametri()+"\nElenco parametri:");
		for (int i = 0; i < numeroParametri; i++) 
		{
			System.out.println("*"+elencoParametri[i]);
		}
	}
	/**
	 * consente un controllo su un carattere in modo che sia interno ai parametri della scrittura esadecimale
	 * @param x
	 * @return vero se e' un carattere esadecimale, falso se non lo e'
	 */
	public boolean checkCharEsa(char x)
	{
		char carattere='a';
		for (int i = 0; i <= 5; i++) 
		{
			if(carattere==x)
				return true;
			carattere=(char) (carattere+1);
			
		}
		carattere='A';
		for (int i = 0; i <= 5; i++) 
		{
			if(carattere==x)
				return true;
			carattere=(char) (carattere+1);
		}
		carattere='0';
		for (int i = 0; i <= 9; i++) 
		{
			if(carattere==x)
				return true;
			carattere=(char) (carattere+1);
		}

		return false;
	}
	/**
	 * consente un controllo sul corretto inserimento di una stringa esadecimale.Richiama il metodo checkChar()
	 * @param x
	 * @return vero se e' una stringa esadecimale, falso se non lo e'
	 */
	public boolean checkString(String string)
	{
		if(string.compareTo("")==0  )
			return false;
		for (int i = 0; i < string.length(); i++) 
		{
			if(checkChar(string.charAt(i))==false)
				return false;
		}
		return true;
	}
	/**
	 * controlla che il carattere non sia uno spazio ' '
	 * @param carattere
	 * @return boolean: true se il carattere non è ' '(spazio)
	 */
	private boolean checkChar(char carattere)
	{
		if(carattere==' '|| carattere=='+'|| carattere=='-'|| carattere=='*')
			return false;
		return true;
	}
	/**
	 * legato a checkCharEsa(), si occupa di controllare che una stringa sia esadecimale
	 * @param esa
	 * @return true se è una stringa esadecimale,false se non lo è
	 */
	public boolean checkStringEsa(String esa)
	{
		boolean corretto;
		if(checkString(esa)==false)
			return false;
		for (int i = 0; i < esa.length(); i++) 
		{
			corretto=checkCharEsa(esa.charAt(i));
			if(corretto==false)
				return false;
		}
		return true;
	}
	/**
	 * 
	 * @return array contenente parametri di ritorno
	 */
	public String[] getElencoParametri() 
	{
		return elencoParametri;
	}
	/**
	 * permette di riconoscere un caratter numerico all'interno di una stringa di caratteri
	 * @param stringa
	 * @return vero se non contiene caratteri numerici,false se ne contiene almeno 1
	 */
	public boolean checkNumber(String stringa) 

	{
		char continua='1';
		for (int i = 0; i <stringa.length(); i++) 
		{
			continua='1';
			for (int j = 0; j <=9; j++) 
			{
				if(stringa.charAt(i)==continua)
					return false;
				continua+=1;
			}
		}
		return true;
	}
	/**
	 * permette di decidere se continuare o meno all'inserimento di un carattere numerico
	 * @return true se l'utente decide di continuare nonostante il carattere numerico, false se invece intende reinserire il dato
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public boolean possibileErrore() throws NumberFormatException, IOException
	{
		ConsoleInput reader=new ConsoleInput();
		String continua;
		do
		{
			System.out.println("Ha inserito dei caratteri numerici, vuole continuare con l'operazione?(si o no)");
			continua=reader.readString();
			if(continua.compareToIgnoreCase("si")==0)
			{
				return true;
			}
			if(continua.compareToIgnoreCase("no")==0)
			{
				return false;
			}
		}while(continua.compareToIgnoreCase("no")!=0 && continua.compareToIgnoreCase("si")!=0);
		return false;
	}
}
