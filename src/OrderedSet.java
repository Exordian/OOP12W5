

/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700) 
 * @since November 2012
 * 
 */

public class OrderedSet<T extends Shorter<? super T>>extends Set<T> implements Iterable<T> {

	@Override
	public void insert (T i) {
		if(i == null)
			return;

		if(contains(i))
			return;
		
		if(root == null) {
			root = new Node<T>(i, null, null);
			size++;
			return;
		}

		Node<T> cur = root;
		
		if(!cur.getElement().shorter(i)) {
			root = new Node<T>(i, null, cur);
			cur.setPrev(root);
			size++;
			return;
		}
		
		while(cur.getNext() != null) {
			if (!cur.getElement().shorter(i)) {
				cur = cur.getPrev();
				break;
			}
			cur = cur.getNext();
		}

		Node<T> temp = new Node<T>(i, cur, cur.getNext());
		
		cur.setNext(temp);

		if(cur.getNext() != null)
			cur.getNext().setPrev(temp);
		
		size++;
	}
}

