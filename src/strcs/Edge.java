package strcs;

public class Edge<E> {

	private Vertex<E> vO;
	private Vertex<E> vF;
	private int cost;
	
	public Edge(Vertex<E> vO, Vertex<E> vF, int cost)
	{
		this.vO = vO;
		this.vF = vF;
		this.cost = cost;
	}

	public void setvO(Vertex<E> vO) {
		this.vO = vO;
	}

	public void setvF(Vertex<E> vF) {
		this.vF = vF;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Vertex<E> getvO() {
		return vO;
	}

	public Vertex<E> getvF() {
		return vF;
	}

	public int getCost() {
		return cost;
	}
	
	
	
	
	
	
}