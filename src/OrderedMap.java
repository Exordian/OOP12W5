import java.util.Iterator;
import java.util.NoSuchElementException;


public class OrderedMap<K extends Shorter<? super K>, V> extends OrderedSet<K> {
	Node<K,V> root;
		
	@Override
	public MapIterator<K, V> iterator() {
		return new MapIterator<K, V>(this);
	}
	
	@Override
	public void insert (K i) {
		if(i == null)
			return;

		if(contains(i))
			return;
		
		if(root == null) {
			root = new Node<K, V>(i, null, null);
			size++;
			return;
		}

		Node<K, V> cur = this.root;
		
		if(!cur.getKey().shorter(i)) {
			root = new Node<K, V>(i, null, cur);
			cur.setPrev(root);
			size++;
			return;
		}
		
		while(cur.getNext() != null) {
			if (!cur.getKey().shorter(i)) {
				cur = cur.getPrev();
				break;
			}
			cur = cur.getNext();
		}

		Node<K, V> temp = new Node<K, V>(i, cur, cur.getNext());
		
		cur.setNext(temp);

		if(cur.getNext() != null)
			cur.getNext().setPrev(temp);
		
		size++;
	}

	
	protected static class Node<K, V> {
		private K key;
		private Set<V> values;
		private Node<K,V> next;
		private Node<K,V> prev;
		
		protected Node(K key, Node<K,V> prev, Node<K,V> next) {
			this.key = key;
			this.prev = prev;
			this.next = next;
			values = new Set<V>();
		}
		
		protected Node<K, V> getNext() {
			return next;
		}

		protected void setNext(Node<K, V> next) {
			this.next = next;
		}

		protected Node<K, V> getPrev() {
			return prev;
		}

		protected void setPrev(Node<K, V> prev) {
			this.prev = prev;
		}

		protected K getKey() {
			return key;
		}
		
		protected Set<V> getElements() {
			return values;
		}
	}
	
	public static class MapIterator<K extends Shorter<? super K>, V> implements Iterator<K>, Iterable<V>{
		OrderedMap<K, V> map;
		Node<K, V> current;
		
		public MapIterator(OrderedMap<K, V> m) {
			this.map = m;
		}
		
		@Override
		public boolean hasNext() {
			if(map.root == null)
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
				current = map.root;
			else
				current = current.getNext();
			return current.getKey();
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
				map.root = current.getNext();
			
			map.size--;
		}
		
		@Override
		public MapElementIterator<V> iterator() {
			return new MapElementIterator<V>(current.getElements());
		}
	}
	
	public static class MapElementIterator<V> extends SetIterator<V> {

		public MapElementIterator(Set<V> s) {
			super(s);
		}
		
		public void add (V i) {
			if(current == null) {
				s.root = new Set.Node<V>(i, null, null);
				return;
			}
			
			Set.Node<V> temp = new Set.Node<V>(i, current, current.getNext());
			
			current.setNext(temp);
		}
	}
}
