package tests;

import static org.junit.Assert.*;


import java.io.IOException;

import org.junit.Test;
import progetto.ConsoleInput;
import progetto.Metodo;

public class TestMetodo 
{

	@Test
	public void testMetodo1() 
	{
		Metodo metodo1=new Metodo();
		assertEquals(null,metodo1.getNome());
	}
	@Test
	public void testMetodo2() 
	{
		Metodo metodo1=new Metodo();
		assertEquals(null,metodo1.getClasseAppartenenza());
	}
	@Test
	public void testMetodo3() 
	{
		Metodo metodo1=new Metodo();
		assertEquals(null,metodo1.getIndirizzoRitornoEsa());
	}
	@Test
	public void testMetodo4() 
	{
		Metodo metodo1=new Metodo();
		assertEquals(0,metodo1.getNumeroParametri());
	}
	@Test
	public void testMetodo5() 
	{
		Metodo metodo1=new Metodo();
		assertEquals(null,metodo1.getValoreRitorno());
	}
	@Test
	public void testGetterSetter() 
	{
		Metodo metodo1=new Metodo();
		metodo1.setNome("metodo1");
		assertEquals("metodo1", metodo1.getNome());
		metodo1.setClasseAppartenenza("classe1");
		assertEquals("classe1", metodo1.getClasseAppartenenza());
		metodo1.setValoreRitorno("int");
		assertEquals("int", metodo1.getValoreRitorno());
		metodo1.setNumeroParametri(0);
		assertEquals(0, metodo1.getNumeroParametri());
		metodo1.setIndirizzoRitornoEsa("123");
		assertEquals("123", metodo1.getIndirizzoRitornoEsa());
	}
	@Test
	public void testInserisciMetodo() throws NumberFormatException, IOException 
	{
		System.out.println("per il test inserire: metodo,classe,int,123,0...");
		Metodo metodo1=new Metodo();
		metodo1.inserisciMetodo();
		metodo1.visualizzaMetodo();
		assertEquals("metodo", metodo1.getNome());
		assertEquals("classe", metodo1.getClasseAppartenenza());
		assertEquals("int", metodo1.getValoreRitorno());
		assertEquals(0, metodo1.getNumeroParametri());
		assertEquals("123", metodo1.getIndirizzoRitornoEsa());
	}
	@Test
	public void testCheckStringEsa1()
	{
		Metodo metodo1=new Metodo();
		String prova="1gda";
		assertEquals(false, metodo1.checkStringEsa(prova));
	}
	@Test
	public void testCheckStringEsa2()
	{
		Metodo metodo1=new Metodo();
		String prova="AG2R";
		assertEquals(false, metodo1.checkStringEsa(prova));
	}
	@Test
	public void testCheckStringEsa3()
	{
		Metodo metodo1=new Metodo();
		String prova="0001";
		assertEquals(true, metodo1.checkStringEsa(prova));
	}
	@Test
	public void testCheckStringEsa4()
	{
		Metodo metodo1=new Metodo();
		String prova="";
		assertEquals(false, metodo1.checkStringEsa(prova));
	}
	@Test
	public void testCheckStringEsa5()
	{
		Metodo metodo1=new Metodo();
		String prova="A D";
		assertEquals(false, metodo1.checkStringEsa(prova));
	}
	@Test
	public void testCheckStringEsa6()
	{
		Metodo metodo1=new Metodo();
		String prova="123";
		assertEquals(true, metodo1.checkStringEsa(prova));
	}
	@Test
	public void testCheckStringEsa7()
	{
		Metodo metodo1=new Metodo();
		String prova="ADF1";
		assertEquals(true, metodo1.checkStringEsa(prova));
	}
	@Test
	public void testCheckTypeReturn1()
	{
		Metodo metodo1=new Metodo();
		String prova="intimo";
		assertEquals(false, metodo1.checkTypeReturn(prova));
	}
	@Test
	public void testCheckTypeReturn2()
	{
		Metodo metodo1=new Metodo();
		String prova="123";
		assertEquals(false, metodo1.checkTypeReturn(prova));
	}
	@Test
	public void testCheckTypeReturn3()
	{
		Metodo metodo1=new Metodo();
		String prova="string";
		assertEquals(true, metodo1.checkTypeReturn(prova));
	}
	@Test
	public void testCheckTypeReturn4()
	{
		Metodo metodo1=new Metodo();
		String prova="STRING";
		assertEquals(true, metodo1.checkTypeReturn(prova));
	}
	@Test
	public void testCheckTypeReturn5()
	{
		Metodo metodo1=new Metodo();
		String prova="";
		assertEquals(false, metodo1.checkTypeReturn(prova));
	}
	@Test (expected= NumberFormatException.class)
	public void testExceptionNumParametri1() throws NumberFormatException, IOException
	{
		ConsoleInput reader=new ConsoleInput();
		System.out.println("inserire il numero di parametri(per il test inserisci 1 2):");
		reader.readInt();
	}
	@Test (expected= NumberFormatException.class)
	public void testExceptionNumParametri2() throws NumberFormatException, IOException
	{
		ConsoleInput reader=new ConsoleInput();
		System.out.println("inserire il numero di parametri(per il test inserisci a):");
		reader.readInt();
	}
	@Test (expected= NumberFormatException.class)
	public void testExceptionNumParametri3() throws NumberFormatException, IOException 
	{
		ConsoleInput reader=new ConsoleInput();
		System.out.println("inserire il numero di parametri(per non inserire nulla):");
		reader.readInt();
	}
	@Test 
	public void testCheckString1() 
	{
		Metodo metodo1=new Metodo();
		String prova="";
		assertEquals(false, metodo1.checkString(prova));
	}
	@Test
	public void testCheckString2()
	{
		Metodo metodo1=new Metodo();
		String prova="a d";
		assertEquals(false, metodo1.checkString(prova));
	}
	@Test
	public void testCheckString3() 
	{
		Metodo metodo1=new Metodo();
		String prova="ciao";
		assertEquals(true, metodo1.checkString(prova));
	}
	@Test 
	public void testCheckNumber1()
	{
		Metodo metodo1=new Metodo();
		String prova="ciao";
		assertEquals(true, metodo1.checkNumber(prova));
	}
	@Test 
	public void testCheckNumber2()
	{
		Metodo metodo1=new Metodo();
		String prova="22";
		assertEquals(false, metodo1.checkNumber(prova));
	}
	@Test 
	public void testCheckNumber3()
	{
		Metodo metodo1=new Metodo();
		String prova="";
		assertEquals(true, metodo1.checkNumber(prova));
	}
	@Test 
	public void testCheckNumber4()
	{
		Metodo metodo1=new Metodo();
		String prova="metodo1";
		assertEquals(false, metodo1.checkNumber(prova));
	}
	@Test 
	public void testCheckNumber5()
	{
		Metodo metodo1=new Metodo();
		String prova="metodo 1";
		assertEquals(false, metodo1.checkNumber(prova));
	}
	@Test 
	public void testPossibileErrore1() throws NumberFormatException, IOException
	{
		Metodo metodo1=new Metodo();
		System.out.println("per il test inserire sio,dopodichè si...");
		assertEquals(true,metodo1.possibileErrore());
	}
	@Test 
	public void testPossibileErrore2() throws NumberFormatException, IOException
	{
		Metodo metodo1=new Metodo();
		System.out.println("per il test inserire 123,dopodichè si...");
		assertEquals(true,metodo1.possibileErrore());
	}
	@Test 
	public void testPossibileErrore3() throws NumberFormatException, IOException
	{
		Metodo metodo1=new Metodo();
		System.out.println("per il test inserire noo,dopodichè no...");
		assertEquals(false,metodo1.possibileErrore());
	}
	
	
	
	
}