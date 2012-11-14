
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700) 
 * @since November 2012
 * 
 */
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
