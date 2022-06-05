package strcs_AVL;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Child;
import model.ComparatorCountry;


public class AVLT_Test {
	
	ComparatorCountry c;
	private AVLT<Child> avlForTest; 

	public void setUpScenary1()
	{
		c = new ComparatorCountry();
		avlForTest = new AVLT<Child>(c);
	}
	
	public void setUpScenary2()
	{
		c = new ComparatorCountry();
		avlForTest = new AVLT<Child>(c);
		Child toAdd = new Child(9,"Valen","Castro","Colombia","Valledupar","Calle 24","Robot");
		avlForTest.add(toAdd);
	}
	
	public void setUpScenary3()
	{
		c = new ComparatorCountry();
		avlForTest = new AVLT<Child>(c);
		Child toAdd = new Child(9,"Valen","Castro","Colombia","Valledupar","Calle 24","Robot");
		Child toAdd2 = new Child(9,"Camila","Torres","Argentina","Buenos Aires","Calle 24","Robot");
		avlForTest.add(toAdd);
		avlForTest.add(toAdd2);
	}

	
	//-------------------
	
	@Test
	public void addTest()
	{
		setUpScenary1();
		Child toAdd = new Child(9,"Valen","Castro","Colombia","Valledupar","Calle 24","Robot");
		avlForTest.add(toAdd);
		assertEquals(toAdd, avlForTest.getRoot().getElement());
	}
	
	@Test
	public void addTest2()
	{
		setUpScenary2();
		Child toAdd = new Child(9,"Camila","Torres","Argentina","Buenos Aires","Calle 24","Robot");
		avlForTest.add(toAdd);
		assertEquals(toAdd, avlForTest.getRoot().getLeft().getElement());
	}
	
	@Test
	public void addTest3()
	{
		setUpScenary3();
		Child toAdd = new Child(9,"Luis","Torres","Peru","Lima","Calle 24","Robot");
		avlForTest.add(toAdd);
		assertEquals(toAdd, avlForTest.getRoot().getRight().getElement());
	}
	
	@Test
	
	public void deleteTest()
	{
		setUpScenary2();
		Child todelete = new Child(9,"Valen","Castro","Colombia","Valledupar","Calle 24","Robot");
		avlForTest.delete(todelete);
		
		assertEquals(todelete.toString2(), avlForTest.getRoot().getElement().toString2());
	}
	
	@Test
	public void deleteTest2()
	{
		setUpScenary3();
		Child todelete = new Child(9,"Camila","Torres","Argentina","Buenos Aires","Calle 24","Robot");
		avlForTest.delete(todelete);
		
		assertEquals(todelete.toString2(), avlForTest.getRoot().getLeft().getElement().toString2());
	}
	
	
	@Test
	public void searchTest2()
	{
		setUpScenary2();
		Child toSearch = new Child(9,"Valen","Castro","Colombia","Valledupar","Calle 24","Robot");
		Child search = avlForTest.search(toSearch);
		
		assertEquals(toSearch.toString2(), search.toString2());
	}
	
	@Test
	public void searchTest3()
	{
		setUpScenary1();
		Child toSearch = new Child(9,"Valen","Castro","Colombia","Valledupar","Calle 24","Robot");
		Child search = avlForTest.search(toSearch);
		
		assertEquals(null, search);
	}
	
	@Test
	public void searchTest4()
	{
		setUpScenary3();
		Child toSearch = new Child(9,"Camila","Torres","Argentina","Buenos Aires","Calle 24","Robot");
		Child search = avlForTest.search(toSearch);
		
		assertEquals(toSearch.toString2(), search.toString2());
	}
	
}
