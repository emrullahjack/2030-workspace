import static org.junit.Assert.*;

import org.junit.Test;

public class TestSorting {

	@Test
	public void testSelectionSort() {
		int[] a = {3, 1, 4, 2};
		int[] sorted = {1, 2, 3, 4};
		Sorting s = new Sorting();
		s.selectionSort(a, a.length);
		assertArrayEquals(sorted, a);
	}
	
	@Test
	public void testInsertionSort() {
		int[] a = {3, 1, 4, 2};
		int[] sorted = {1, 2, 3, 4};
		Sorting s = new Sorting();
		s.insertionSort(a, a.length);
		assertArrayEquals(sorted, a);
	}

}
