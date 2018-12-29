
public class PointCollector {
	Point[] points = new Point[100];
	int nop;
	
	Point[] getPoints() {
		Point[] currentPoints = new Point[nop];
		
		for (int i = 0; i < nop; i++) {
			currentPoints[i] = points[i];
		}
		
		return currentPoints;
	}
	
	void addPoint(Point pointToAdd) {
		points[nop] = pointToAdd;
		nop++;
	}
	
	void addPoint(int x, int y) {
		Point pointToAdd = new Point(x, y);
		addPoint(pointToAdd);
	}
	
}
