package strcs_MA;
import java.util.List;

import strcs_LA.Graph;
import strcs_LA.VertexLA;

public class GraphMA<E> implements Graph<E>  {

	private VertexMA<E>[] vertex;
	private int[][] adjacencyMatrix;
	private int size = 0;
	

	@SuppressWarnings("unchecked")
	public GraphMA(int vertexNum) {
		adjacencyMatrix = new int[vertexNum][vertexNum];
		vertex = (VertexMA<E>[]) new Object[vertexNum];
	}


	@Override
	public void add(E e) 
	{
		
		VertexMA<E> toAdd = new VertexMA<>(e,size);
		vertex[size] = toAdd;
		size++;
	}


	@Override
	public VertexLA<E> search(int index) {
	
		return null;
	}


	@Override
	public void delete(VertexLA<E> v) {
		// TODO Auto-generated method stub
		
	}



	public void addEdge(VertexMA<E> vi, VertexMA<E> vf, int cost) 
	{
		int indexI = vi.getIndex();
		int indexF = vf.getIndex();
		
		
	}


	@Override
	public void addEdge(VertexLA<E> vi, VertexLA<E> vf, int cost) {
		// TODO Auto-generated method stub
		
	}

	
	
}


