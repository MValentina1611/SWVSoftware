package strcs_LA;

import java.util.List;

public interface Graph<E> {
	
	
	public void add(E e);
	public List<VertexLA<E>> search(VertexLA<E> v);
	public void delete(VertexLA<E> v);
	public void addEdge(VertexLA<E> vi , VertexLA<E> vf, int cost);
	

}
