import static org.junit.Assert.*;
import java.util.Hashtable;
import org.junit.Test;

public class IntegerKeyTester {

	@Test
	public void testHashtable() {
		Hashtable<IntegerKey, String> table = new Hashtable<>();
		IntegerKey key1 = new IntegerKey(39);
		IntegerKey key2 = new IntegerKey(39);
		assertTrue(key1.equals(key2));
		assertTrue(key1.hashCode() == key2.hashCode());
		table.put(key1, "D");
		assertTrue(table.get(key2).equals("D"));
	}

}
