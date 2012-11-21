import java.util.Scanner;



/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700) 
 * @since November 2012
 * 
 */
public class Description implements Shorter<Description> {

	private String text;
	
	public Description(String text) {
		//text != null;
		this.text = text;
	}
	
	@Override
	public boolean shorter(Description s) {
		//s != null;
		if(s.toString().length() > text.length())
			return true;
		return false;
		//returns: true if length of text s is greater than length of this.text
		//         else false
	}
	
	public String toString() {
		return text;
	}
	
	public int countRows() {
		int count = 0;
		Scanner sc = new Scanner(this.text);
		while(sc.hasNextLine()) {
			sc.nextLine();
			count++;
		}
		return count;
		//returns number of lines
	}

}
