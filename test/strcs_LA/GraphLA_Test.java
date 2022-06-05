package strcs_LA;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import model.Child;

public class GraphLA_Test {



	private Child childTest1;
	private Child childTest2;
	private VertexLA<Child> vertexForTestI;
	private VertexLA<Child> vertexForTestF;
	private GraphLA<Child> graphForTest;
	
	public void setUpScenary1(){
		childTest1 = new Child(10,"Gabriel","Hernandez","Colombia","Cali","Cr 100 # AA-BB", "Hot Wheels");
		childTest2 = new Child(12,"Hugo","Fernandez","Colombia","Cali","Cr 90 # AA-BB", "Transformer");
		vertexForTestI = new VertexLA<Child>(childTest1);
		vertexForTestF = new VertexLA<Child>(childTest2);
		graphForTest = new GraphLA<Child>();	
	}
	
	public void setUpScenary2(){
		childTest2 = new Child(10,"Diego","Perez","Colombia","Cali","Cr 10 # AA-BB", "Pelota de Futbol");
		childTest1 = new Child(12,"Sebastian","Ortiz","Colombia","Cali","Cr 40 # AA-BB", "Pelota de Basketball");
		vertexForTestI = new VertexLA<Child>(childTest1);
		vertexForTestF = new VertexLA<Child>(childTest2);
		graphForTest = new GraphLA<Child>();	
	}
	
	@Test
	public void testAddGraph(){
		setUpScenary1();
		
		graphForTest.addEdge(vertexForTestI, vertexForTestF, 0);
		
		boolean added = graphForTest.getGraph().isEmpty();
		int answer=0;
		
		if(added == true) {
			answer=1;
		}
		
		assertEquals(0, answer);
	}
	
	@Test
	public void testSearchGraph(){
		setUpScenary2();
		
		graphForTest.addEdge(vertexForTestI, vertexForTestF, 0);

		ArrayList<VertexLA<Child>> array4test = graphForTest.search(vertexForTestI);
		
		assertEquals(childTest2.getName(), array4test.get(0).getElement().getName());
	}
	
	@Test
	public void testDeleteGraph(){
		setUpScenary1();
		
		int deleted=0;
		
		graphForTest.addEdge(vertexForTestI, vertexForTestF, 0);
		
		graphForTest.removeVertex(vertexForTestI);
		graphForTest.removeVertex(vertexForTestF);
		
		boolean added = graphForTest.getGraph().isEmpty();
		
		if(added == true) {
			deleted=1;
		}
		
		assertEquals(1, deleted);
	}
	
	@Test
	public void testbfsGraph(){
		setUpScenary2();
		
		int bfs=0;
		
		graphForTest.addEdge(vertexForTestI, vertexForTestF, 0);
		
		GraphLA<Child> graphForTest1 = graphForTest.bfs(vertexForTestI, childTest2);
		
		HashMap<VertexLA<Child>,Integer> graphIndexTest1 = graphForTest.getGraphIndex();
		HashMap<VertexLA<Child>,Integer> graphIndexTest2 = graphForTest1.getGraphIndex();
		
		int index1 = graphIndexTest1.get(vertexForTestI);
		int index2 = graphIndexTest1.get(vertexForTestF);
		
		if(index1!=index2) {
			bfs=1;
		}
		
		assertEquals(1, bfs);
	}
	
}
