
public abstract class Polygon {
	// this is an abstract class example.
	double[] sides;
	Polygon(double[] sides) { this.sides = sides; }
	
	void grow() {
		
		for (int i = 0; i < sides.length; i++) {
			sides[i]++;
		}
		
	}
	
	double getPerimeter() {
		double perimeter = 0;
		
		for (int i = 0; i < sides.length; i++) {
			perimeter += sides[i];
		}
		
		return perimeter;
	}
	
	abstract double getArea();	
}
