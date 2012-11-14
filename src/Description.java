
// class complete
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
	}
	
	public String toString() {
		return text;
	}

}
