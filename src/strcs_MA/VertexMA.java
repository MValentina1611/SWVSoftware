package strcs_MA;

public class VertexMA <E> {

	private E element;

	private int index;
	
	public VertexMA(E e, int index)
	{
		this.element = e;
		this.index = index;
	}
	
	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}
