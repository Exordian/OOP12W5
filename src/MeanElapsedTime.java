
public class MeanElapsedTime extends ElapsedTime {

	private Set<Double> s;
	
	public MeanElapsedTime () {
		s = new Set<Double>();
	}
	
	// TODO: insert times, count, shorter, method to get greatest value
	public void addTime(){
		s.insert(null);
	}
	
	@Override
	public int count() {
		return 0;
	}

}
