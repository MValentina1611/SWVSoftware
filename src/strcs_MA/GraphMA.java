package strcs_MA;
import java.util.List;

import strcs_LA.Graph;
import strcs_LA.VertexLA;

public class GraphMA<E> implements Graph<E>  {

	private VertexMA<E>[] vertex;
	private int[][] adyacencyMatrix;
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public GraphMA(int vertexNum) {
		
		vertex = new VertexMA[vertexNum];
		adyacencyMatrix = new int[vertexNum][vertexNum];
	}
	
	public void add(E e)
	{
		VertexMA<E> newVertex = new VertexMA<E>(e);
		vertex[size] = newVertex;
		size++;
	}

	@Override
	public List<VertexLA<E>> search(VertexLA<E> v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(VertexLA<E> v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(VertexLA<E> vi, VertexLA<E> vf, int cost) {
		// TODO Auto-generated method stub
		
	}
}
