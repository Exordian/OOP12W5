

/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700) 
 * @since November 2012
 * 
 */

public class OrderedSet<T extends Shorter<T>>extends Set<T> implements Iterable<T> {

	@Override
	public void insert (T i) {
		if(i == null)
			return;
	
		if(root == null) {
			root = new Node(i);
			size++;
			return;
		}
		
		Node cur = root;
		Node temp = root;
		boolean shorter = false;

		while(cur.getNext() != null) {
			if (!cur.getElement().shorter(i)) {
				if (cur.getElement() == i) {
					return;
				}
				shorter = true;
				break;
			}
			temp = cur;
			cur = cur.getNext();
		}

		if (shorter) {
			temp.setNext(new Node(i));
			temp.getNext().setNext(cur);
		} else {
			cur.setNext(new Node(i));
		}
		size++;
	}
}

