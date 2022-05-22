package strcs_LA;

import java.util.ArrayList;

public class VertexLA<E> {

	private E element;
	private int adjacencyCost;
	private int index;
	private ArrayList<VertexLA<E>> adyacencyList;
	
	
	public VertexLA(E e, int index)
	{
		this.element = e;
		this.adjacencyCost = -1;
		this.adyacencyList = new ArrayList<VertexLA<E>>();
		this.index = index;
	}

	public VertexLA(E e)
	{
		this.element = e;
		this.adjacencyCost = -1;
		this.adyacencyList = new ArrayList<VertexLA<E>>();
		this.index = -1;
	}
	
	public E getElement() {
		return element;
	}

	public int getIndex() {
		return index;
	}

	public int getAdjacencyCost() {
		return adjacencyCost;
	}
	public void setAdjacencyCost(int cost) {
		this.adjacencyCost = cost;
	}

	public ArrayList<VertexLA<E>> getAdyacencyList() {
		return adyacencyList;
	}


	
	
	
	
	
}
