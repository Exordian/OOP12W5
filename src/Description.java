
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700) 
 * @since November 2012
 * 
 */
public class Description implements Shorter<Description> {

	private String text;
	
	public Description(String text) {
		this.text = text;
	}
	
	@Override
	public boolean shorter(Description s) {
		if(s.toString().length() > text.length())
			return true;
		return false;
		//returns: true if length of text s is greater than length of this.text
		//         else false
	}
	
	public String toString() {
		return text;
	}

}
