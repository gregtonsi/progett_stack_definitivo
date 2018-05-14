package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import progetto.Metodo;
import progetto.Nodo;

public class TestNodo 
{

	@Test
	public void testGetInfo() 
	{
		Metodo metodo=new Metodo();
		Nodo nodo=new Nodo(metodo);
		assertEquals(metodo, nodo.getInfo());
	}

	@Test
	public void testSetInfo() throws NumberFormatException, IOException 
	{
		Metodo metodo=new Metodo();
		Metodo metodo2=new Metodo();
		metodo.setNome("metodo1");
		metodo2.setNome("metodo2");
		Nodo nodo=new Nodo(metodo);
		nodo.setInfo(metodo2);
		assertEquals(metodo2.getNome(), nodo.getInfo().getNome());
	}

	@Test
	public void testGetLinkNull() 
	{
		Metodo metodo=new Metodo();
		Nodo nodo=new Nodo(metodo);
		assertEquals(null, nodo.getLink());
	}

	@Test
	public void testSetGetLink() 
	{
		Metodo metodo=new Metodo();
		Nodo nodo=new Nodo(metodo);
		Nodo nodo2=new Nodo(metodo);
		nodo.setLink(nodo2);
		assertEquals(nodo2, nodo.getLink());
	}
	

}
