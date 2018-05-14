package progetto;
import java.io.Serializable;
/**
 * 
 * @author gregtonsi:
 * Istanzia il nodo di una lista
 */
public class Nodo implements Serializable
{
	private Metodo info;
	private Nodo link;
	/**
	 * permette la creazione di un nodo
	 * @param metodo
	 */
	public Nodo(Metodo metodo)
	{
		setLink(null);
		setInfo(metodo);
	}
	/**
	 * 
	 * @return parte informativa del nodo
	 */
	public Metodo getInfo() 
	{
		return info;
	}
	/**
	 * imposta il contenuto informativo del nodo
	 * @param info
	 */
	public void setInfo(Metodo info) {
		this.info = info;
	}
	/**
	 * 
	 * @return indirizzo del prossimo nodo
	 */
	public Nodo getLink() {
		return link;
	}
	/**
	 * imposta l'indirizzo del prossimo nodo
	 * @param link
	 */
	public void setLink(Nodo link) {
		this.link = link;
	}
}
