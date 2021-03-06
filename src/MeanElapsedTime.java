
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700) 
 * @since November 2012
 * 
 */
public class MeanElapsedTime extends ElapsedTime {
	private Set<Double> s;
	
	public MeanElapsedTime () {
		s = new Set<Double>();
	}

	
	public boolean shorter(ElapsedTime e) {
		//e != null; times of set s >= 0;
		double sum = 0;
		double average = 0;
		for(double t : this.s) {
			sum += t;
		}
		average = sum/s.size();
		
		if(e.getTime() > average)
			return true;
		return false;
		//returns: true if time of parameter e is greater than the average of the times of the set s
		//         else false
	}
	
	@Override
	public int count() {
		return s.size();
		//returns size of set s
	}
	
	public void addTime(double time) {
		//time >= 0;
		s.insert(time);
		//time has been added to set s
	}
	
	public double getMaxValue() {
		/*if(s.size() == 0) {
			return null;
		}*/
		double maxval = 0;
		for(double t : this.s) {
			if(t > maxval) {
				maxval = t;
			}
		}
		return maxval;
		//returns maximum value of set s
	}
	
	public String toString() {
		String output = "times:\n";
		for(double d : this.s) {
			output += d +"\n";
		}
		return output;
		//returns output string of times
	}
}
