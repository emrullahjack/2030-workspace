
public class Point {
	// You can put points on 5 * 5 map.	
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void moveHorizontally(int x) throws xOutOfBoundsException {		
		
		if ((this.x + x) < -5 || (this.x + x) > 5) {
			throw new xOutOfBoundsException("Horizontal move declined. X out of bounds.");
		} else {
			this.x += x;
		}
		
	}
	
	void moveVertically(int y) throws yOutOfBoundsException {
		
		if ((this.y + y) < -5 || (this.y + y) > 5) {
			throw new yOutOfBoundsException("Vertical move declined. Y out of bounds.");
		} else {
			this.y += y;
		}
		
	}
	
}
