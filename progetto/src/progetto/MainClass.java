package progetto;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String[] elencoMenu= {"1.push","2.pop","3.interrompi Esecuzione","4.carica stack","5.visualizza stack"};
		Menu menu=new Menu(elencoMenu);
		int scelta;
		Stack pila=new Stack();
		Metodo metodo;
		System.out.println("si ricorda di porre le giuste path in modo da far lavorare nel modo corretto il programma...");
		do
		{
			scelta=menu.scelta();
			if(scelta==1)
			{
				try 
				{
					metodo=new Metodo();
					metodo.inserisciMetodo();
					metodo.visualizzaMetodo();
					pila.push(metodo);
				} catch (NumberFormatException e) 
				{
					// TODO Auto-generated catch block
					System.out.println(e.toString());
				} catch (IOException e)
				{
					System.out.println("errore di lettura dati...");
				}
				
			}
			if(scelta==2)
			{
				try 
				{
					metodo=pila.pop();
					System.out.println("Metodo eliminato con successo.\nMETODO:"+metodo.getNome()+"-->RETURN:"+metodo.getValoreRitorno());
				} catch (StackException e) 
				{
					// TODO Auto-generated catch block
					System.out.println(e.toString());
				}
				
			}
			if(scelta==3)
			{			
				
				try 
				{
					Metodo[] arrayPila=pila.convertiStack();
					arrayPila=Stack.selectionSortCrescente(arrayPila);
					Stack pilaOrdinata=new Stack();
					pilaOrdinata.convertiMetodo(arrayPila);
					pilaOrdinata.salvaCSV();
					String nomeFile=pila.getNomeBIN();
					pila.serializzazione(nomeFile);
					break;
				}
				catch (IOException e) 
				{
					System.out.println("errore...");
				} 
				catch (FileException e) 
				{
					System.out.println(e.toString());
				} 
				catch (StackException e)
				{
					System.out.println(e.toString());
					break;
				}
			}
			if(scelta==4)
			{

				try 
				{
					String nomeFile=pila.percorsoStack();
					pila=pila.deserializzazione("C:\\Users\\ale\\Desktop\\progetto_stack_def\\progetto\\stack\\"+nomeFile);
				
				} 
				catch (NumberFormatException e) 
				{
					System.out.println(e.toString());
				}
				catch (IOException e) 
				{
					System.out.println("errore...");
				} 
				catch (ClassNotFoundException e) 
				{
					System.out.println("errore...");
				} 
				catch (StackException e) 
				{
					System.out.println(e.toString());
				} 
			}
			if(scelta==5)
			{
				System.out.println(pila.toString());
			}
			
		}while(true);
	}

}

