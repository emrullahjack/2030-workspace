package version_1;

public class B {
	B() { }
	
	void mb(int i) {
		A oa = new A();
		// From the method call below,
		// we know that B.mb is the caller of A.ma.
		// To handle the exception below, we choose to
		// catch it.
		try {
			oa.ma(i);
		}
		catch(NegValException nve) {
			// Do something to handle the exception.
			System.out.println("From B.mb: neg val: " + i);
		}
	}
}
