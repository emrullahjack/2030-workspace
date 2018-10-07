package points;

/* This version does not define equals method,
 * meaning that when comparing two PointV1 objects,
 * the default version of equals method inherited from Object, 
 * which compare references, will be used.  
 */
public class PointV1 {
	double x; 
	double y;
	
	PointV1(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
