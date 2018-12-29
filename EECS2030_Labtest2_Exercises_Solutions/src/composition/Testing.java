package composition;

public class Testing {

	public static void main(String[] args) {
		String s = new String();
		s = "this is somethig";
		
		String b = new String();
		b = "this is something";
		
		System.out.println(s == b);
		System.out.println(s.equals(b));
	}

}
