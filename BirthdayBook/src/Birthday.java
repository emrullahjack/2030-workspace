
public class Birthday {
	private int month;
	private int day;
	
	public Birthday(int month, int day) {
		
		if ((1 <= month && month <= 12) && (1 <= day && day <= 31)) {
			this.month = month;
			this.day = day;
		} else {
			throw new IllegalArgumentException();
		}
		
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	@Override
	public String toString() {
		String m = "";
		
		if (month == 1) {
			m = "January";
		} else if (month == 2) {
			m = "February";
		} else if (month == 3) {
			m = "March";
		} else if (month == 4) {
			m = "April";
		} else if (month == 5) {
			m = "May";
		} else if (month == 6) {
			m = "June";
		} else if (month == 7) {
			m = "July";
		} else if (month == 8) {
			m = "August";
		} else if (month == 9) {
			m = "September";
		} else if (month == 10) {
			m = "October";
		} else if (month == 11) {
			m = "November"; 
		} else if (month == 12) {
			m = "December";
		}
		
		return m + " " + getDay();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		} 
		
		if (obj == null || (this.getClass() != obj.getClass())) {
			return false;
		}
		
		Birthday other = (Birthday) obj;	
		return (this.month == other.month && this.day == other.day);		
	}
	
}
