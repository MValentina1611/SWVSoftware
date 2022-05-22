package strcs;
public interface Graph<E> {

	public void addVertex(E vertex);
	public E getVertex(int num);
	public void addEdge(Vertex<E> vi, Vertex<E> vf);
	public int edgeCost(Vertex<E> vi, Vertex<E> vf);
		
}
