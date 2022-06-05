package strcs_AVL;

import java.util.Comparator;



public class AVLT<E> implements BST_General<E> {

	private Node<E> root;
	private Comparator<E> comparator;

	public AVLT(Comparator<E> c)
	{
		comparator = c;
	}


	@Override
	public void add(E e) {
		Node<E> toAdd = new Node<>(e);
		if(root == null) {
			root = toAdd;
		}else {
			add(toAdd, root);
		}

	}

	public void add(Node<E> toAdd, Node<E> root) {
		if(comparator.compare(toAdd.getElement(), root.getElement()) >= 0) {
			if(root.getRight() == null) {
				root.setRight(toAdd);
				toAdd.setParent(root);
			}else {
				add(toAdd, root.getRight());
			}
		}else {
			if(root.getLeft() == null) {
				root.setLeft(toAdd);
				root.setParent(root);
			}else {
				add(toAdd,root.getLeft());
			}
		}
		balance(toAdd);
	}
	  
	    
	public E search(E toSearch)
	{
		if(root == null) {
			return null;
		}else {
			return search(root, toSearch).getElement();
		}
	}
 	
	@Override
	public Node<E> search(Node<E> root, E toSearch) 
	{
		if(root == null) {
			return root;
		}else if(comparator.compare(toSearch, root.getElement())==0) {
			return root;
		}else if(comparator.compare(toSearch, root.getElement())>0) {
			return search(root.getRight(), toSearch);
		}else {
			return search(root.getLeft(), toSearch);
		}
	}

	@Override
	public Node<E> delete(E toDelete) 
	{
		Node<E> remove = search(root, toDelete);
		
		if(remove != null && remove.getLeft() != null)
		{	
			removeNode(remove);
			if (remove.getParent()!=null)
			{
				balance(remove.getParent());
			}
		}
		return remove;
	}
	
	private void removeNode(Node<E> d) 
	{
		if(d!=null) {	
			if(isleaf(d)) {
				if(d==root) {
					root=null;
				}else if(d == d.getParent().getLeft()) {
					d.getParent().setLeft(null);
				}else {
					d.getParent().setRight(null);
				}
			}else if(d.getLeft()==null || d.getRight()==null) {
				Node<E> aux;
				if(d.getLeft()!=null) {
					aux=d.getLeft();
				}else {
					aux=d.getRight();
				}
				aux.setParent(d.getParent());
				if(d==root) {
					root=aux;
				}else if(d==d.getParent().getLeft()) {
					d.getParent().setLeft(aux);
				}else {
					d.getParent().setRight(aux);
				}
			}else {
				Node<E> succesor = min(d.getRight());
				d.setElement(succesor.getElement());
				removeNode(succesor);
			}
		}
	}
	
	private boolean isleaf(Node<E> d) {
		if(d.getRight()==null && d.getLeft()==null) {
			return true;
		}else {
			return false;
		}
	}

	private void balance(Node<E> n) {
		
		n.height();
		
		int balance = fb(n);
		
		if(balance > 1 && fb(n.getLeft())>=0)
		{
			rotateRight(n);
		}
		if(balance > 1 && fb(n.getLeft()) < 0)
		{
			rotateLeft(n.getLeft());
			rotateRight(n);
		}
		if(balance < -1 && fb(n.getRight())<=0)
		{
			rotateLeft(n);
		}
		if( balance < -1 && fb(n.getRight()) > 0)
		{
			rotateRight(n.getRight());
			rotateLeft(n);
		}
		
	}
	
	public int getheight(Node<E> n){
    	if(n==null) {
    		return 0;
    	}else {
    		return 1+max(getheight(n.getRight()), getheight(n.getLeft()));
    	}
    }

    private int max(int l, int r) {
		if(l>=r) {
			return l;
		}else {
			return r;
		}
		
	}

    public int fb(Node<E> n){
    	return getheight(n.getRight())-getheight(n.getLeft());
    }
	
	private void rotateLeft(Node<E> n) {
		if(!n.equals(root)) {	
			Node<E> p = n.getParent();

			n.setParent(n.getRight());
			n.getRight().setParent(p);
			n.setRight(n.getRight().getLeft());
			if(n.getRight() != null) {
				n.getRight().setParent(n);
			}
			n.getParent().setParent(p);
			n.getParent().setLeft(n);

			if(p.getLeft() == n) {
				p.setLeft(n.getParent());
			} else {
				p.setRight(n.getParent());
			}			
		} else {
			Node<E> left = root;
			Node<E> aux = n.getRight();
			
			root.setRight(aux.getLeft());
			if(aux.getLeft() != null) {
				aux.getLeft().setParent(root);
			}
			root = aux;
			root.setParent(left.getParent());
			root.setLeft(left);
			left.setParent(aux);
		}
	}
	
	private void rotateRight(Node<E> n) {
		if(!n.equals(root)) {
			Node<E> p = n.getParent();
			
			n.setParent(n.getLeft());
			n.getLeft().setParent(p);
			n.setLeft(n.getLeft().getRight());
			if(n.getLeft() != null) {
				n.getLeft().setParent(n);
			}
			n.getParent().setParent(p);
			n.getParent().setRight(n);
			
			if(p.getLeft() == n) {
				p.setLeft(n.getParent());
			} else {
				p.setRight(n.getParent());
			}
		} else {
			Node<E> right = root;
			Node<E> aux = n.getLeft();
			
			root.setLeft(aux.getRight());
			if(aux.getRight() != null) {
				aux.getRight().setParent(root);
			}
			root = aux;
			root.setParent(right.getParent());
			root.setRight(right);
			right.setParent(aux);
		}
	}
	
	
	private Node<E> min(Node<E> r){
		if(r.getLeft()==null) {
			return r;
		}else {
			return min(r.getLeft());
		}
	}
	
	public Node<E> getRoot(){
        return root;
    }
	
	public String printRelations(){
        return printRelations(root);
    }

    private String printRelations(Node<E> toPrint){
        String relations = "";
        if(toPrint != null){
            relations += printRelations(toPrint.getLeft());
            if(toPrint.getParent() != null){
                relations += "Parent: " + toPrint.getParent().getElement() + "\n";
            } else{
                relations += "Parent: null"  + "\n";
            }
            
            relations += "Current: " + toPrint.getElement() + "\n";
            
            if(toPrint.getLeft() != null){
                relations += "Left: " + toPrint.getLeft().getElement() + "\n";
            } else{
                relations += "Left: null"  + "\n";
            }
            
            if(toPrint.getRight() != null){
                relations += "Right: " + toPrint.getRight().getElement() + "\n";
            } else{
                relations += "Right: null"  + "\n";
            }
            
            relations += "\n===================================\n";
            relations += printRelations(toPrint.getRight());
        }
        return relations;
    }
	
}
	



