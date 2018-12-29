public class Course {
	String title;
	double fee;
	
	Course(String title, double fee) {
		this.title = title;
		this.fee = fee;
	}
	
	double getFee() {
		return fee;
	}
	
	String getTitle() {
		return title;
	}
}
