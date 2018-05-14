package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import progetto.Metodo;
import progetto.Stack;
import progetto.StackException;

public class TestStack 
{
	@Test
	public void testGetElementi1() 
	{
		Stack stack=new Stack();
		assertEquals(0,stack.getElementi());
	}
	@Test
	public void testGetElementi2() 
	{
		Stack stack=new Stack();
		Metodo metodo1=new Metodo();
		Metodo metodo2=new Metodo();
		Metodo metodo3=new Metodo();
		stack.push(metodo1);
		stack.push(metodo2);
		stack.push(metodo3);
		assertEquals(3,stack.getElementi());
	}
	@Test
	public void testPush1() throws NumberFormatException, IOException 
	{
		Stack stack=new Stack();
		Metodo metodo1=new Metodo();
		metodo1.setNome("metodo1");
		Metodo metodo2=new Metodo();
		metodo2.setNome("metodo2");
		stack.push(metodo1);
		stack.push(metodo2);
		assertEquals("Head-->metodo2;metodo1;", stack.toString());
	}
	@Test
	public void testPush2() throws NumberFormatException, IOException 
	{
		Stack stack=new Stack();
		Metodo metodo1=new Metodo();
		metodo1.setNome("metodo1");
		Metodo metodo2=new Metodo();
		metodo2.setNome("metodo2");
		Metodo metodo3=new Metodo();
		metodo3.setNome("metodo3");
		Metodo metodo4=new Metodo();
		metodo4.setNome("metodo4");
		Metodo metodo5=new Metodo();
		metodo5.setNome("metodo5");
		stack.push(metodo1);
		stack.push(metodo2);
		stack.push(metodo3);
		stack.push(metodo4);
		stack.push(metodo5);
		assertEquals("Head-->metodo5;metodo4;metodo3;metodo2;metodo1;", stack.toString());
	}
	@Test
	public void testToString() 
	{
		Stack stack=new Stack();
		Metodo metodo1=new Metodo();
		metodo1.setNome("metodo2");
		stack.push(metodo1);
		assertEquals("Head-->metodo2;", stack.toString());
	}

	@Test
	public void testPop1() throws StackException 
	{
		Stack stack=new Stack();
		Metodo metodo1=new Metodo();
		metodo1.setNome("metodo1");
		Metodo metodo2=new Metodo();
		metodo2.setNome("metodo2");
		stack.push(metodo1);
		stack.push(metodo2);
		stack.pop();
		assertEquals("Head-->metodo1;", stack.toString());
	}
	@Test
	public void testPop2() throws StackException 
	{
		Stack stack=new Stack();
		Metodo metodo1=new Metodo();
		metodo1.setNome("metodo1");
		Metodo metodo2=new Metodo();
		metodo2.setNome("metodo2");
		stack.push(metodo1);
		stack.push(metodo2);
		stack.pop();
		stack.pop();
		assertEquals("Head-->", stack.toString());
		
	}
	@Test (expected=StackException.class)
	public void testPop3() throws StackException 
	{
		Stack stack=new Stack();
		Metodo metodo1=new Metodo();
		metodo1.setNome("metodo1");
		Metodo metodo2=new Metodo();
		metodo2.setNome("metodo2");
		stack.push(metodo1);
		stack.push(metodo2);
		stack.pop();
		stack.pop();
		stack.pop();
	}
	public void testConvertiStack() throws StackException 
	{
		Stack stack=new Stack();
		Metodo metodo1=new Metodo();
		metodo1.setNome("metodo1");
		Metodo metodo2=new Metodo();
		metodo2.setNome("metodo2");
		stack.push(metodo1);
		stack.push(metodo2);
		Metodo[] array=stack.convertiStack();
		assertEquals("metodo2;metodo1", array[0].getNome()+";"+array[1].getNome());
	}
	@Test
	public void testConvertiMetodo() throws StackException 
	{
		Stack stack=new Stack();
		Metodo metodo1=new Metodo();
		metodo1.setNome("metodo1");
		Metodo metodo2=new Metodo();
		metodo2.setNome("metodo2");
		stack.push(metodo1);
		stack.push(metodo2);
		Metodo[] array=stack.convertiStack();
		Stack stackNew=new Stack();
		stackNew.convertiMetodo(array);
		assertEquals("Head-->metodo2;metodo1;", stackNew.toString());
	}
	@Test
	public void testSelectionSortCrescente1() throws StackException 
	{
		Stack stack=new Stack();
		Metodo metodo1=new Metodo();
		metodo1.setNome("ci");
		Metodo metodo2=new Metodo();
		metodo2.setNome("ca");
		stack.push(metodo1);
		stack.push(metodo2);
		Metodo[] array=stack.convertiStack();
		array=Stack.selectionSortCrescente(array);
		assertEquals("ca;ci", array[0].getNome()+";"+array[1].getNome());
	}
	@Test
	public void testSelectionSortCrescente2() throws StackException 
	{
		Stack stack=new Stack();
		Metodo metodo1=new Metodo();
		metodo1.setNome("dia");
		Metodo metodo2=new Metodo();
		metodo2.setNome("cano");
		stack.push(metodo1);
		stack.push(metodo2);
		Metodo[] array=stack.convertiStack();
		array=Stack.selectionSortCrescente(array);
		assertEquals("cano;dia", array[0].getNome()+";"+array[1].getNome());
	}
	@Test
	public void testSelectionSortCrescente3() throws StackException 
	{
		Stack stack=new Stack();
		Metodo metodo1=new Metodo();
		metodo1.setNome("anno");
		Metodo metodo2=new Metodo();
		metodo2.setNome("cano");
		stack.push(metodo1);
		stack.push(metodo2);
		Metodo[] array=stack.convertiStack();
		array=Stack.selectionSortCrescente(array);
		assertEquals("anno;cano", array[0].getNome()+";"+array[1].getNome());
	}
	@Test (expected=IOException.class)
	public void testSerializzazione() throws IOException 
	{
		Stack stack=new Stack();
		stack.serializzazione("c:\\percorsoNonEsistente");
	}
	@Test (expected=StackException.class)
	public void testDeserializzazione() throws NumberFormatException, IOException, StackException, ClassNotFoundException  
	{
		//immetti numero sbagliato o carattere,funziona solo se cambi la path a seconda del computer in cui si trova
		Stack stack=new Stack();
		String nomeFile=stack.percorsoStack();
		stack.deserializzazione("C:\\Users\\ale\\Desktop\\progetto_stack_def\\progetto\\stack\\"+nomeFile);
	}
	
	
}
