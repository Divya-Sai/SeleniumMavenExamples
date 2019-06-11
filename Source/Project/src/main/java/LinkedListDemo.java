import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList l = new LinkedList();
		l.add("durga");
		l.add(30);
		l.add(null);
		l.add("durga");
		System.out.println(l);
		l.set(0, "Divya");
		System.out.println(l);
		l.set(0, "Sai");
		System.out.println(l);
		l.addFirst("EEEE");
		System.out.println(l);
		
	}

}
