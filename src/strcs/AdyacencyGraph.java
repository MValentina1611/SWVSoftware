package strcs;

import java.util.ArrayList;
import java.util.HashMap;

public class AdyacencyGraph<E> implements Graph<E>
{

	HashMap<Vertex<E>,ArrayList<Edge<E>>> graph;
	
	@Override
	public void addVertex(E element) {
		
		Vertex<E> newVertex = new Vertex<E>(element);
		
		graph.put(newVertex, newVertex.getAdjacency());
	}

	@Override
	public E getVertex(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEdge(Vertex<E> vi, Vertex<E> vf) {
		
		
	}

	@Override
	public int edgeCost(Vertex<E> vi, Vertex<E> vf) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
}
