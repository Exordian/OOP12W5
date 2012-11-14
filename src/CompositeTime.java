
public class CompositeTime extends ElapsedTime {

	private Double[] times;
	
	public CompositeTime (Double [] times) {
		this.times = times;
	}

	// TODO: Shorter missing
	
	@Override
	public int count() {
		return times.length;
	}

}
