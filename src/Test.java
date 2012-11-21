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
		
		//1.)
		System.out.println("1.)\n");
		OrderedSet<Description> s = new OrderedSet<Description>();
		Description d1 = new Description("abcdefg\nhijklmnop\nqrstuvw\nxyz");
		Description d2 = new Description("111111111\n222222");
		Description d3 = new Description("ABC\n123\n987");
		Description d4 = new Description("*****\n**-**\n*---*\n**-**\n*****");
		s.insert(d1);
		s.insert(d2);
		s.insert(d3);
		s.insert(d4);
		Iterator<Description> it1 = s.iterator();
		Description d = null;
		while(it1.hasNext()) {
			d = it1.next();
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
		System.out.println("2.)\n");
		OrderedMap<MeanElapsedTime, CompositeTime> m = new OrderedMap<MeanElapsedTime, CompositeTime>();
		MeanElapsedTime e1 = new MeanElapsedTime();
		MeanElapsedTime e2 = new MeanElapsedTime();
		e1.addTime(3.98);
		e1.addTime(5.03);
		e1.addTime(0.01);
		e1.addTime(8.99);
		e2.addTime(1.03);
		e2.addTime(65.4);
		e2.addTime(7.28);
		e2.addTime(9.14);
		
		m.insert(e1);
		m.insert(e2);
		CompositeTime e3 = new CompositeTime(new Double[]{2.03, 4.5, 1.09, 7.8});
		CompositeTime e4 = new CompositeTime(new Double[]{1.5, 3.01, 50.4, 80.0});
		
		OrderedMap.MapIterator<MeanElapsedTime, CompositeTime> it3 = m.iterator();
		MeanElapsedTime e = null;
		while(it3.hasNext()) {
			e = it3.next();
			OrderedMap.MapElementIterator<CompositeTime> w = it3.iterator();
			w.add(e3);
			System.out.println("MeanElapsedTime:");
			System.out.print(e.toString());
			System.out.println("maxval: " +e.getMaxValue()+ "\n");
			for(CompositeTime ct : it3) {
				System.out.println("CompositeTime:");
				System.out.print(ct.toString());
				System.out.println("minval: " +ct.getMinValue());
			}
			System.out.println();
		}
		
		System.out.println("***********");
		OrderedMap<MeanElapsedTime, CompositeTime> m2 = new OrderedMap<MeanElapsedTime, CompositeTime>();
		m2.insert(e2);
		m2.insert(e1);
		it3 = m2.iterator();
		while(it3.hasNext()) {
			e = it3.next();
			OrderedMap.MapElementIterator<CompositeTime> w = it3.iterator();
			w.add(e4);
			System.out.println("MeanElapsedTime:");
			System.out.print(e.toString());
			System.out.println("maxval: " +e.getMaxValue()+ "\n");
			for(CompositeTime ct : it3) {
				System.out.println("CompositeTime:");
				System.out.print(ct.toString());
				System.out.println("minval: " +ct.getMinValue());
			}
			System.out.println();
		}
		
		//3.)
		System.out.println("3.)");
		OrderedSet<MeanElapsedTime> s3 = m;
		MeanElapsedTime e5 = new MeanElapsedTime();
		MeanElapsedTime e6 = new MeanElapsedTime();
		e5.addTime(1.2);
		e5.addTime(6.3);
		e6.addTime(7.0);
		e6.addTime(4.11);
		s3.insert(e5);
		s3.insert(e6);
		
		Iterator<MeanElapsedTime> it4 = s3.iterator();
		while(it4.hasNext()) {
			e = it4.next();
			System.out.println("maxval: " +e.getMaxValue());
		}
		System.out.println();
		
		//4.)
		System.out.println("4.)");
		OrderedSet<ElapsedTime> s4 = new OrderedSet<ElapsedTime>();
				
		s4.insert(e1);
		s4.insert(e2);
		s4.insert(e3);
		s4.insert(e4); 
		
		Iterator<ElapsedTime> it = s4.iterator();
		ElapsedTime et = null;
		while(it.hasNext()) {
			et = it.next();
			System.out.print(et);
			System.out.println("size     = " + et.count());
			System.out.println();
		}
	}
}
