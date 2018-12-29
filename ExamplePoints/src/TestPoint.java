import static org.junit.Assert.*;

import org.junit.Test;

public class TestPoint {
	Point p1 = new Point(2, 3);
	Point p2 = new Point(3, 5);
	
	@Test
	public void test01_PointConstructor() {
		assertEquals("X location not correct for p1", p1.x, 2);
		assertEquals("Y location not correct for p1", p1.y, 3);
		assertEquals("X location not correct for p2", p2.x, 3);
		assertEquals("Y location not correct for p2", p2.y, 5);
	}

	@Test
	public void test02_moveHorizontally() {

		try {
			p1.moveHorizontally(2);
		} catch (xOutOfBoundsException e) {
			System.out.println("Invalid horizontal movement. X out of bounds.");
		}

		assertEquals("Horizontal location not correct", p1.x, 4);
	}
	
	@Test
	public void test03_moveVertically() {
		
		try {
			p2.moveVertically(0);
		} catch (yOutOfBoundsException e) {
			System.out.println("Invalid vertical movement. Y out of bounds.");
		}
		
		assertEquals("Vertical location not correct", p2.y, 5);
	}
	
}
