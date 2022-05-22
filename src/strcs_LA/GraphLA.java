package strcs_LA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphLA<E> implements Graph<E> {
	
	private HashMap<VertexLA<E>, ArrayList<VertexLA<E>>> graph;
	private int size = 0;

	@Override
	public void add(E e) {
	
		VertexLA<E> newVertex = new VertexLA<>(e, size);
		size++;
		graph.put(newVertex, newVertex.getAdyacencyList());
	}

	@Override
	public void addEdge(VertexLA<E> vi, VertexLA<E> vf, int cost) {
		vf.setAdjacencyCost(cost);
		graph.get(vi).add(vf);
	}
	

	@Override
	public void delete(VertexLA<E> v) {
		
		//remove de la lista de adycencia;
		graph.remove(v);
		
	}
	
	
	@Override
	public List<VertexLA<E>> search(VertexLA<E> v) {
		
		return graph.get(v);
	}

	

	

}
