package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import strcs_AVL.Node;

public class SantaListTest {
	
	SantaList santaListForTest;
	
	public void setUpScenary1()
	{
		santaListForTest = new SantaList();
	}
	
	public void setUpScenary2()
	{
		
		santaListForTest = new SantaList();
		Child toAdd = new Child(9,"Luis","Castro","Colombia","Cali","Calle 24-30","Robot");
		santaListForTest.addChild(toAdd);
	}
	
	public void setUpScenary3()
	{
		santaListForTest = new SantaList();
		Child toAdd = new Child(9,"Luis","Castro","Colombia","Cali","Calle 24-30","Robot");
		Child toAdd2 = new Child(9,"Caro","Torres","Argentina","Buenos Aires","Calle 30-50","Bici");
		santaListForTest.addChild(toAdd);
		santaListForTest.addChild(toAdd2);
	}

	//--------------
	
	@Test
	public void testAddChild()
	{
		setUpScenary1();
		Child toAdd = new Child(9,"Luis","Castro","Colombia","Cali","Calle 24-30","Robot");
		santaListForTest.addChild(toAdd);
		
		Child childExpected = new Child(9,"Luis","Castro","Colombia","Cali","Calle 24-30","Robot");
		assertEquals(childExpected.toString2(), santaListForTest.getToShow().get(0).toString2() );
	}
	
	@Test
	public void testAddChild2()
	{
		setUpScenary2();
		Child toAdd = new Child(9,"Caro","Torres","Argentina","Buenos Aires","Calle 30-50","Bici");
		santaListForTest.addChild(toAdd);
		
		Child childExpected = new Child(9,"Caro","Torres","Argentina","Buenos Aires","Calle 30-50","Bici");
		assertEquals(childExpected.toString2(), santaListForTest.getToShow().get(1).toString2() );
	}

	
	@Test
	public void testDeleteChild()
	{
		setUpScenary3();
		Child toDelete = new Child(9,"Luis","Castro","Colombia","Cali","Calle 24-30","Robot");
		santaListForTest.deleteChild(toDelete);
		Child childExpected = new Child(9,"Caro","Torres","Argentina","Buenos Aires","Calle 30-50","Bici");
		
		assertEquals(childExpected.toString2(), santaListForTest.getSantaListByNames().getRoot().getElement().toString2());
	}
	
	
	@Test
	public void testFilterByCountry()
	{
		setUpScenary3();
		ArrayList<Node<Child>> filtered = santaListForTest.countryFilter("Argentina");
		
		ArrayList<Node<Child>> expected = new ArrayList<Node<Child>>();
		
		expected.add(new Node<Child>(new Child(9,"Caro","Torres","Argentina","Buenos Aires","Calle 30-50","Bici")) );
		
		assertEquals(expected.get(0).getElement().toString2(), filtered.get(0).getElement().toString2());
	}
	
	@Test
	public void testFilterByCountry2()
	{
		setUpScenary1();
		ArrayList<Node<Child>> filtered = santaListForTest.countryFilter("Argentina");
		
		assertEquals(null, filtered);
	}
	
}
