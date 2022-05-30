package strcs_LA;
import java.util.HashMap;

public class GraphLA<E> implements Graph<E> {
	
	private HashMap<Integer,VertexLA<E>> graph;
	private int size = 0;

	@Override
	public void add(E e) {
	
		VertexLA<E> newVertex = new VertexLA<>(e,size);
		size++;
		graph.put(size, newVertex);
	}

	
	public void addEdge(VertexLA<E> vi, VertexLA<E> vf, int cost) {
		vf.setAdjacencyCost(cost);
		
		if(graph.containsKey(vi.getIndex()))
		{
			graph.get(vi.getIndex()).getAdyacencyList().add(vf);
		}
	
	}
	

	@Override
	public void delete(VertexLA<E> v) {
		
		for(int i = 0; i < size; i++)
		{
			if(graph.get(i).getAdyacencyList().contains(v))
			{
				graph.get(i).getAdyacencyList().remove(v);
			}
		}
		
		graph.remove(v.getIndex());
	
	}
	
	
	@Override
	public VertexLA<E> search(int index) {
		return graph.get(index);
	}

	

	

}
