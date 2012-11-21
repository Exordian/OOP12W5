
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700) 
 * @since November 2012
 * 
 */
public class CompositeTime extends ElapsedTime {

	private Double[] times;
	
	public CompositeTime (Double [] times) {
		//times != null;
		this.times = times;
	}

	public boolean shorter(ElapsedTime e) {
		//e != null; e.getTime() >= 0;
		double sum = 0;
		for(int i = 0; i < times.length; i++) {
			sum += times[i]; 
		}
		if(e.getTime() > sum) 
			return true;
		return false;
	}
	
	public double getMinValue() {
		if(times.length == 0) {
			return -1;
		}
		double minval = times[0];
		for(int i = 1; i < times.length; i++) {
			if(times[i] < minval) {
				minval = times[i];
			}
		}
		return minval;
		//returns minimum value of times-array
	}
	
	@Override
	public int count() {
		return times.length;
	}
	
	public String toString() {
		String output = "times:\n";
		for(int i = 0; i < this.times.length; i++) {
			output += this.times[i] +"\n";
		}
		return output;
		//returns output string of times
	}

}
