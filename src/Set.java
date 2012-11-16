import java.util.Iterator;
import java.util.NoSuchElementException;

/**
*
* @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700) 
* @since November 2012
* 
*/
public class Set<T> implements Iterable<T> {

	protected Node root = null;
	
	@Override
	public Iterator<T> iterator() {
		return new java.util.Iterator<T> () {
			Node current, prev;
			
			{current = root;
			 prev = root;}
			
			@Override
			public boolean hasNext() {
				if(current != null && current.getNext() != null)
					return true;
				return false;
			}

			@Override
			public T next() {
				if(!hasNext())
					throw new NoSuchElementException();
				prev = current;
				current = current.getNext();
				return current.getElement();
			}

			@Override
			public void remove() {
				if(current == null) // emtpy iterator
					return;
				
				Node following = hasNext()? current.getNext() : null;
				
				if(prev == null) { // must be root
					root = following;
					return;
				}
				prev.setNext(following);
			}
			
		};
	}
	
	public void insert (T i) {
		if(i == null)
			return;
		
		if(root == null) {
			root = new Node(i);
			return;
		}
		
		Node cur = root;
		while(cur.getNext() != null) {
			if(i == cur.getElement() ) // or equals?
				return;
			cur = cur.getNext();
		}
		cur.setNext(new Node(i));
		
	}

	
	protected class Node {
		private T element;
		private Node next;
		
		public Node(T element) {
			this.element = element;
		}
		
		public void setNext(Node node) {
			this.next = node;
		}

		protected T getElement() {
			return element;
		}

		protected Node getNext() {
			return next;
		}
	}
}
