
public class Triangle extends Polygon {
	
	Triangle(double side, double side1, double side2) {
		super(new double[3]);
		sides[0] = side; sides[1] = side1; sides[2] = side2;
	}
	
	double getArea() {
		double s = getPerimeter() * 0.5;
		double area = Math.sqrt(s * (s - sides[0]) * (s - sides[1]) * (s - sides[2]));
		return area;
	}
	
}
