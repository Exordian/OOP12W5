import java.util.Iterator;
import java.util.NoSuchElementException;

/**
*
* @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700) 
* @since November 2012
* 
*/
public class Set<T> implements Iterable<T> {

	protected Node<T> root = null;
	protected int size = 0;
	
	@Override
	public Iterator<T> iterator() {
		return new SetIterator<T>(this);
	}
	
	public void insert (T i) {
		if(i == null)
			return;
		
		if(root == null) {
			root = new Node<T>(i, null, null);
			size++;
			return;
		}
		
		Node<T> cur = root;
		while(cur.getNext() != null) {
			if(i == cur.getElement() ) // or equals?
				return;
			cur = cur.getNext();
		}
		cur.setNext(new Node<T>(i, cur, null));
		size++;
		//i has been added;
	}
	
	public int size() {
		return this.size;
		//returns size
	}
	
	protected boolean contains(T i) {
		
		for(T x : this) {
			if(x == i)
				return true;
		}
		return false;
			
	}

	
	protected static class Node<K> {
		private K element;
		private Node<K> next;
		private Node<K> prev;
		
		protected Node(K element, Node<K> prev, Node<K> next) {
			//element != null;
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		
		protected void setNext(Node<K> node) {
			//node != null;
			this.next = node;
		}

		protected K getElement() {
			return element;
		}

		protected Node<K> getNext() {
			return next;
		}

		protected Node<K> getPrev() {
			return prev;
		}
	
		protected void setPrev(Node<K> prev) {
			this.prev = prev;
		}
	}

	protected static class SetIterator<K> implements Iterator<K> {
		Node<K> current;
		Set<K> s;
		
		public SetIterator(Set<K> s) {
			this.s = s;
		}
		
		@Override
		public boolean hasNext() {
			if(s.root == null)
				return false;
			if(current != null && current.getNext() == null)
				return false;

			return true;
		}

		@Override
		public K next() {
			if(!hasNext())
				throw new NoSuchElementException();
			if(current == null)
				current = s.root;
			else
				current = current.getNext();
			return current.getElement();
		}

		@Override
		public void remove() {
			if(current == null) // empty iterator
				return;

			if(current.getPrev() != null)
				current.getPrev().setNext(current.getNext());
			
			if(current.getNext() != null)
				current.getNext().setPrev(current.getPrev());
			
			if(current.getPrev() == null)
				s.root = current.getNext();
			
			s.size--;
		}
		
	};

}
