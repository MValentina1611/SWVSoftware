package model;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;


import org.junit.jupiter.api.Test;

import strcs_AVL.Node;
import strcs_LA.GraphLA;
import strcs_LA.VertexLA;

public class DeliveryRouteTest {

	private DeliveryRoute deliveryRouteForTest;
	
	
	public void setUpScenary2()
	{
		Child toAdd = new Child(9,"Caro","Torres","Argentina","Buenos Aires","Calle 30-50","Bici");
		Child toAdd2 = new Child(10,"Pedro","Perez","Argentina","La Plata","Calle 24-30","Robot");
		Child toAdd3 = new Child(11,"Carlos","Rojas","Argentina","Mar del Plata","Calle 24-30","Robot");
		
		ArrayList<Node<Child>> childrenByCountry = new ArrayList<Node<Child>>();
		 childrenByCountry.add(new Node<Child>(toAdd));
		 childrenByCountry.add(new Node<Child>(toAdd2));
		 childrenByCountry.add(new Node<Child>(toAdd3));
		 
		
		deliveryRouteForTest = new DeliveryRoute("C",childrenByCountry);
	}
	
	//--------------------------------------------------------
	
	@Test
	public void deliveryRouteTest()
	{
		setUpScenary2();
		GraphLA<Child> routeExpected = new GraphLA<>();
	

		VertexLA<Child> toAdd = new VertexLA<Child>(new Child(9,"Caro","Torres","Argentina","Buenos Aires","Calle 30-50","Bici"));
		VertexLA<Child> toAdd2 = new VertexLA<Child>(new Child(11,"Carlos","Rojas","Argentina","Mar del Plata","Calle 24-30","Robot"));
	
		routeExpected.addEdge(toAdd, toAdd2, 24);
		
		assertTrue(routeExpected.getGraph().size() ==  deliveryRouteForTest.getRoute().getGraph().size());
	}


}
