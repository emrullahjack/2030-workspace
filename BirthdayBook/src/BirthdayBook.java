
public class BirthdayBook {
	private final int MAX_CAPACITY = 10;
	private Entry[] entries;
	private int noe;
	
	public BirthdayBook() {
		entries = new Entry[MAX_CAPACITY];
		noe = 0;
	}
	
	public int getNumberOfEntries() {
		return noe;
	}
	
	public Entry[] getEntries() {
		Entry[] currentEntries = new Entry[noe];
		
		for (int i = 0; i < noe; i++) {
			currentEntries[i] = entries[i];
		}
		
		return currentEntries;
	}
	
	private int indexOf(String name) {
		int index = -1;
		
		for (int i = 0; i < noe && index == -1; i++) {
			
			if (name.equals(entries[i].getName())) {
				index = i;
			}
			
		}
		
		return index;
	}
	
	public boolean nameExists(String name) {
		boolean result = true;
		
		if(indexOf(name) == -1) {
			result = false;
		}
		
		return result;
	}
	
	public Birthday getBirthday(String name) {
		
		if(indexOf(name) == -1) {
			return null;
		} else {
			return entries[indexOf(name)].getBirthday();
		}
		
	}
	
	public String[] getReminders(Birthday bDay) {
		int numberOfReminders = 0;
		
		for (int i = 0; i < noe; i++) {
			
			if (entries[i].getBirthday().equals(bDay)) {
				numberOfReminders++;
			}
			
		}
		
		String[] reminders = new String[numberOfReminders];
		int j = 0;
		
		for (int i = 0; i < noe; i++) {
			
			if (entries[i].getBirthday().equals(bDay)) {
				reminders[j] = entries[i].getName();
				j++;
			}
			
		}
		
		return reminders;
	}
	
	public String[] getReminders(int month, int day) {
		return getReminders(new Birthday(month, day));
	}
	
	public void removeEntry(String name) {
		int index = indexOf(name);
		
		if (indexOf(name) != -1) {
			
			for (int i = index; i < noe - 1; i++) {
				entries[i] = entries[i + 1];
			}
			
			entries[noe - 1] = null;
			noe--;			
		}
		
	}
	
	public void addEntry(String name, Birthday bDay) {
		int index = indexOf(name);
		
		if(index < 0) {
			Entry entry = new Entry(name, bDay);
			entries[noe] = entry;
			noe++;
		} else {
			entries[index].setBirthday(bDay);
		}
		
	}
	
	public void addEntry(String name, int month, int day) {
		addEntry(name, new Birthday(month, day));
	}
	
	@Override
	public String toString() {
		String s = "There are " + noe + " entries in the book\n";
		
		for (int i = 0; i < noe; i++) {
			s += entries[i].toString() + "\n";
		}
		
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		
		BirthdayBook other = (BirthdayBook) obj;
		
		if (this.noe == 0 || other.noe == 0 || this.noe != other.noe) {
			return false;
		} else {
			boolean result = true;
			
			for (int i = 0; i < noe && result; i++) {
				result = this.entries[i].equals(other.entries[i]);
			}
			
			return result;
		}
		
	}
	
}
