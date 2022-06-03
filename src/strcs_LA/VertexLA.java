package strcs_LA;

import java.util.ArrayList;

public class VertexLA<E> {

	private E element;
	private int adjacencyCost;
	private int index;
	private ArrayList<VertexLA<E>> adyacencyList;
	
	//For BFS
	private VertexLA<E> ancestor;
	private boolean visited = false;
	private int pDistance = 0;
	
	//For Dijkstra
	private boolean visitedD = false;
	
	public VertexLA(E e, int index)
	{
		this.element = e;
		this.adjacencyCost = -1;
		this.adyacencyList = new ArrayList<VertexLA<E>>();
		this.index = index;
		this.ancestor = null;
		this.pDistance = 0;

	}

	public VertexLA(E e)
	{
		this.element = e;
		this.adjacencyCost = -1;
		this.adyacencyList = new ArrayList<VertexLA<E>>();
		this.index = -1;
		this.ancestor = null;
		this.pDistance = 0;
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



	public VertexLA<E> getAncestor() {
		return ancestor;
	}

	public void setAncestor(VertexLA<E> ancestor) {
		this.ancestor = ancestor;
	}

	public int getpDistance() {
		return pDistance;
	}

	public void setpDistance(int pDistance) {
		this.pDistance = pDistance;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public boolean isVisitedD() {
		return visitedD;
	}

	public void setVisitedD(boolean visitedD) {
		this.visitedD = visitedD;
	}


	public String toString()
	{
		return this.element.toString();
	}
	
}
