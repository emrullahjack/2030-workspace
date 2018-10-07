
public class Entry {
	private String name;
	private Birthday bDay;
	
	public Entry(String name, Birthday bDay) {
		this.name = name;
		this.bDay = bDay;
	}
	
	public Entry(String name, int month, int day) {
		Birthday bDay = new Birthday(month, day);
		this.name = name;
		this.bDay = bDay;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Birthday getBirthday() {
		return this.bDay;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthday(Birthday bDay) {
		this.bDay = bDay;
	}
	
	public void setBirthday(int month, int day) {
		Birthday bDay = new Birthday(month, day);
		this.setBirthday(bDay);
	}
	
	@Override
	public String toString() {
		return name + " was born on " + bDay.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		
		Entry other = (Entry) obj;
		return this.name.equals(other.getName()) && this.bDay.equals(other.getBirthday());		
	}
	
}
