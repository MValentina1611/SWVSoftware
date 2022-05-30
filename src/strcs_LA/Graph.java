package strcs_LA;

public interface Graph<E> {
	
	
	public void add(E e);
	public VertexLA<E> search(int index);
	public void delete(VertexLA<E> v);
	public void addEdge(VertexLA<E> vi, VertexLA<E> vf, int cost);
	

}
