package strcs;
import java.util.ArrayList;

public class Vertex<E> {

	private E element;
	private int num;
	private ArrayList<Edge <E>> adjacency;
	
	public Vertex(E element) 
	{	
		this.element = element;
		num = -1;
		adjacency = new ArrayList<Edge <E>>();

	}

	public void addEdge(Edge<E> edge)
	{
		adjacency.add(edge);
	}

	public ArrayList<Edge<E>> getAdjacency() {
		return adjacency;
	}

	public void setAdjacency(ArrayList<Edge<E>> adjacency) {
		this.adjacency = adjacency;
	} 
	
	
	
}
