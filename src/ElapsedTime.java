
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700) 
 * @since November 2012
 * 
 */
public abstract class ElapsedTime implements Shorter<ElapsedTime> { // TODO: evtl muss elapsedTime ersetzt werden damit in den erbenden klassen shorter sinnvoll genutzt werden kann

	@Override
	public boolean shorter(ElapsedTime s) {
		// TODO Auto-generated method stub
		return false;
	}
    // TODO: muessen wir die klasse irgendwann instanziieren? wenn ja muss abstract weg
	public abstract int count();
}