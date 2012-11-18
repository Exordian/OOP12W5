
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700) 
 * @since November 2012
 * 
 */
public abstract class ElapsedTime implements Shorter<ElapsedTime> { // TODO: evtl muss elapsedTime ersetzt werden damit in den erbenden klassen shorter sinnvoll genutzt werden kann
	
	protected double time = 0;
	
	protected void setTime(double time) {
		//t >= 0;
		this.time = time;
	}
	protected double getTime() {
		return this.time;
	}

	public boolean shorter(ElapsedTime s) {
		//s != null; s.getTime() >= 0;
		if(s.getTime() > this.time)
			return true;
		return false;
	}
    // TODO: muessen wir die klasse irgendwann instanziieren? wenn ja muss abstract weg
	public abstract int count();
}
