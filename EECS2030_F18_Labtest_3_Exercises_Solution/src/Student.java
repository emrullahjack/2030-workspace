
/*
 * We define what is common between ResidentStudent and
 * NonResidentStudent in this single place.
 */

public class Student {
	String name;
	Course[] registeredCourses;
	int noc; /* number of courses */

	/* premimumRate or discountRate does not belong
	 * to this class. */

	Course[] getCourses() {
		Course[] cs = new Course[noc];
		for (int i = 0; i < noc; i++) {
			cs[i] = registeredCourses[i];
		}
		return cs;
	}

	Student(String name) {
		this.name = name;
		registeredCourses = new Course[5];
	}

	void drop(Course c) {
		boolean found = false;
		int index = -1;
		for(int i = 0; !found && i < noc; i ++) {
			if(registeredCourses[i] == c) {
				index = i;
				// as soon as we finds the course,
				// exit from the loop.
				found = true;
			}
		}
		if(index >= 0) {
			for(int j = index; j < noc - 1; j ++) {
				registeredCourses[j] = registeredCourses[j + 1];
			}
			noc --;
			registeredCourses[noc] = null;
		} 
	}

	void register(Course c) { 
		registeredCourses[noc] = c;
		noc ++;
	}

	double getTuition() {
		double base = 0;

		for(int i = 0; i < noc; i ++) {
			base += registeredCourses[i].getFee();
		}

		return base;
	}
}
