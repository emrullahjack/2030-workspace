package version_1;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer i: ");
		int i = input.nextInt();
		B ob = new B();
		// From the method call below,
		// we know B.mb is the callee of Tester.main.
		// In Tester.main, we are not required to 
		// handle the NegValException, because it has
		// already been handled in the callee.
		ob.mb(i);
		input.close();
	}

}
