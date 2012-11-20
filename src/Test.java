import java.util.Iterator;


/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700) 
 * @since November 2012
 * 
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//TODO: tests for OrderedMap
		
		//1.)
		System.out.println("1.)\n**OrderedSet**");
		OrderedMap<Description, String> s = new OrderedMap<Description, String>();
		Description d1 = new Description("abcdefg\nhijklmnop\nqrstuvw\nxyz");
		Description d2 = new Description("111111111\n222222");
		Description d3 = new Description("ABC\n123\n987");
		Description d4 = new Description("*****\n**-**\n*---*\n**-**\n*****");
		s.insert(d1);
		s.insert(d2);
		s.insert(d3);
		s.insert(d4);
		OrderedMap.MapIterator<Description, String> it1 = s.iterator();
		Description d = null;
		while(it1.hasNext()) {
			d = it1.next();
			OrderedMap.MapElementIterator<String> wut = it1.iterator();
			wut.add("wat");
			for(String st : it1)
				System.out.println("lol: " + st);
			System.out.println(d.toString());
			System.out.println("Rows: " +d.countRows()+ "\n");
		}
		System.out.println("**************");
		OrderedSet<Description> s2 = new OrderedSet<Description>();
		s2.insert(d2);
		s2.insert(d3);
		s2.insert(d1);
		s2.insert(d4);
		Iterator<Description> it2 = s2.iterator();
		while(it2.hasNext()) {
			d = it2.next();
			System.out.println(d.toString());
			System.out.println("Rows: " +d.countRows()+ "\n");
		}
		System.out.println();
		
		//2.)
		/*System.out.println("2.)\n**OrderedMap**");
		OrderedMap<MeanElapsedTime, CompositeTime> m = new OrderedMap<MeanElapsedTime, CompositeTime>();
		//...
		*/
		
		//3.)
		
		
		//4.)
		/*System.out.println("**OrderedSet**");
		OrderedSet<ElapsedTime> s3 = new OrderedSet<ElapsedTime>();
		*/
		
		
		
		//5.)
		System.out.println("+++++++++++++++\n++++++5.)++++++\n+++++++++++++++");
		OrderedSet<ElapsedTime> s4 = new OrderedSet<ElapsedTime>();
		MeanElapsedTime e1 = new MeanElapsedTime();
		MeanElapsedTime e2 = new MeanElapsedTime();
		CompositeTime e3 = new CompositeTime(new Double[]{2.03, 4.5, 1.09, 7.8});
		CompositeTime e4 = new CompositeTime(new Double[]{1.5, 3.01, 50.4, 80.0});
		e1.addTime(3.98);
		e1.addTime(5.03);
		e1.addTime(0.01);
		e1.addTime(8.99);
		e2.addTime(1.03);
		e2.addTime(65.4);
		e2.addTime(7.28);
		e2.addTime(9.14);
		
		s4.insert(e1);
		s4.insert(e2);
		s4.insert(e3);
		s4.insert(e4);
		
		Iterator<ElapsedTime> it = s4.iterator();
		ElapsedTime e = null;
		while(it.hasNext()) {
			e = it.next();
			if(e instanceof MeanElapsedTime) {
				System.out.println(((MeanElapsedTime)e).toString());
				System.out.println("maxvalue = " +((MeanElapsedTime)e).getMaxValue());
				System.out.println("size     = " +((MeanElapsedTime)e).count());
				System.out.println("-----");
			}
			else if(e instanceof CompositeTime) {
				System.out.println(((CompositeTime)e).toString());
				System.out.println("minvalue = " +((CompositeTime)e).getMinValue());
				System.out.println("size     = " +((CompositeTime)e).count());
				System.out.println("-----");
			}
		}

	}

}
