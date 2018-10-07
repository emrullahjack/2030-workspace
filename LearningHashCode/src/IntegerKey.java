
public class IntegerKey {
	private int key;
	
	public IntegerKey(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	
	@Override
	public int hashCode() {
		return key % 11;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		
		IntegerKey other = (IntegerKey) obj;
		return this.key == other.getKey();	
	}
	
}
