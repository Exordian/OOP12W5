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
	protected int size = 0;
	
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
				if(current == null) // empty iterator
					return;
				
				Node following = hasNext()? current.getNext() : null;
				
				if(prev == null) { // must be root
					root = following;
					size--;
					return;
				}
				prev.setNext(following);
				size--;
			}
			
		};
	}
	
	public void insert (T i) {
		if(i == null)
			return;
		
		if(root == null) {
			root = new Node(i);
			size++;
			return;
		}
		
		Node cur = root;
		while(cur.getNext() != null) {
			if(i == cur.getElement() ) // or equals?
				return;
			cur = cur.getNext();
		}
		cur.setNext(new Node(i));
		size++;
		//i has been added;
	}
	
	public int size() {
		return this.size;
		//returns size
	}

	
	protected class Node {
		private T element;
		private Node next;
		
		public Node(T element) {
			//element != null;
			this.element = element;
		}
		
		public void setNext(Node node) {
			//node != null;
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
