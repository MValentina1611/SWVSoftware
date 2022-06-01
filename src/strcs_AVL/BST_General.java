package strcs_AVL;

public interface BST_General<E> {

	public void add(E e);
	public Node<E> delete(E toDelete);
	public Node<E> search(Node<E> node, E element);

	   

		
}
