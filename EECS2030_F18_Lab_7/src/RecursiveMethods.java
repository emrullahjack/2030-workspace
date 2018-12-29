import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * You can assume that n is positive.
	 * e.g., fibArray(5) returns an array {1, 1, 2, 3, 5}.
	 * @param n the first n Fibonacci numbers 
	 * @return an array representing the first n Fibonacci numbers
	 * 
	 * You are forbidden to use the fibList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while). 
	 */
	
	public int[] fibArray(int n) {

		if (n == 2) {
			int[] seq = { 1, 1 };
			return seq;
		} else {
			int[] seq = new int[n];
			seq[0] = 1;
			seq[1] = 1;
			fibArrayHelper(2, seq);
			return seq;
		}

	}

	private void fibArrayHelper(int i, int[] seq) {

		if (i != seq.length) {
			seq[i] = seq[i - 1] + seq[i - 2];
			i++;
			fibArrayHelper(i, seq);
		}

	}
	
	/**
	 * Return a list storing the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * You can assume that n is positive.
	 * e.g., fibList(5) returns a list {1, 1, 2, 3, 5}.
	 * @param n the first n Fibonacci numbers 
	 * @return a list representing the first n Fibonacci numbers
	 * 
	 * You are forbidden to use the fibArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> fibList(int n) {

		if (n == 2) {
			ArrayList<Integer> seq = new ArrayList<Integer>();
			seq.add(1);
			seq.add(1);
			return seq;
		} else {
			ArrayList<Integer> seq = new ArrayList<Integer>();
			seq.add(1);
			seq.add(1);
			fibListHelper(2, seq, n);
			return seq;
		}

	}

	private void fibListHelper(int i, List<Integer> seq, int n) {

		if (i != n) {
			seq.add(seq.get(i - 1) + seq.get(i - 2));
			i++;
			fibListHelper(i, seq, n);
		}

	}
	
	/**
	 * Return whether or not an array represents the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * The array may or may not be empty.
	 * e.g., isFibArray({1, 2}) returns false and isFibArray({1, 1, 2, 3, 5, 8}) returns true.
	 * @param a an array
	 * @return true if input array a (of length n) represents the first n Fibonacci numbers; false otherwise.
	 * 
	 * You are forbidden to use the isFibList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public boolean isFibArray(int[] a) {

		if (a.length == 0) {
			return true;
		} else if (a.length == 1) {
			return a[0] == 1;
		} else if (a.length == 2) {
			return a[0] == 1 && a[1] == 1;
		} else {
			return a[0] == 1 && a[1] == 1 && isFibArrayHelper(2, a);
		}

	}

	private boolean isFibArrayHelper(int i, int[] a) {
		boolean result = true;

		if (i != a.length) {

			result = a[i] == a[i - 1] + a[i - 2] && isFibArrayHelper(i + 1, a);

		}

		return result;
	}
	
	/**
	 * Return whether or not a list represents the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * The array may or may not be empty.
	 * e.g., isFibList({1, 2}) returns false and isFibList({1, 1, 2, 3, 5, 8}) returns true.
	 * @param a an array
	 * @return true if input list a (of length n) represents the first n Fibonacci numbers; false otherwise.
	 * 
	 * You are forbidden to use the isFibArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public boolean isFibList(List<Integer> list) {

		if (list.size() == 0) {
			return true;
		} else if (list.size() == 1) {
			return list.get(0) == 1;
		} else if (list.size() == 2) {
			return list.get(0) == 1 && list.get(1) == 1;
		} else {
			return list.get(0) == 1 && list.get(1) == 1 && isFibListHelper(2, list);
		}

	}
	
	private boolean isFibListHelper(int i, List<Integer> list) {
		boolean result = true;

		if (i != list.size()) {
			result = list.get(i) == list.get(i - 1) + list.get(i - 2) && isFibListHelper(i + 1, list);
		}

		return result;
	}
	
	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1, 
	 * consisting of all elements of array a and integer i.
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of array a and integer i.
	 * e.g., insertIntoSortedArray({1, 2, 4, 5}, 3) returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 * You are forbidden to use the insertIntoSortedList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {

		if (a.length == 0) {
			int[] array = { i };
			return array;
		} else if (a.length == 1) {

			if (a[0] > i) {
				int[] array = { i, a[0] };
				return array;
			} else {
				int[] array = { a[0], i };
				return array;
			}

		} else {
			int[] array = Arrays.copyOf(a, a.length + 1);
			insertIntoSortedArrayHelper(array, 0, array.length - 1, i);
			return array;
		}

	}
	
	private void insertIntoSortedArrayHelper(int[] array, int from, int to, int i) {

		if (from == to) {
			array[from] = i;
			return;
		}

		if (array[from] > i) {
			int temp = array[from];
			array[from] = i;
			insertIntoSortedArrayHelper(array, from + 1, to, temp);
		} else {
			insertIntoSortedArrayHelper(array, from + 1, to, i);
		}

	}
	
	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1, 
	 * consisting of all elements of the input list and integer i.
	 * @param list a list that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of the input list and integer i.
	 * e.g., insertIntoSortedList({1, 2, 4, 5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 * You are forbidden to use the insertIntoSortedArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {

		if (list.size() == 0) {
			list.add(i);
			return list;
		} else if (list.size() == 1) {

			if (list.get(0) > i) {
				list.add(0, i);
				return list;
			} else {
				list.add(i);
				return list;
			}

		} else {
			insertIntoSortedListHelper(list, 0, list.size() - 1, i);
			return list;
		}

	}
	
	private void insertIntoSortedListHelper(List<Integer> list, int from, int to, int i) {

		if (from > to) {
			list.add(i);
			return;
		}

		if (list.get(from) > i) {
			int temp = list.get(from);
			list.add(from, i);
			list.remove(from + 1);
			insertIntoSortedListHelper(list, from + 1, to, temp);
		} else {
			insertIntoSortedListHelper(list, from + 1, to, i);
		}

	}
	
	/**
	 * Given two sorted arrays left and right, 
	 * return a sorted array of size left.length + right.length, 
	 * consisting of all elements of arrays left and right.
	 * @param left a sorted array
	 * @param right a sorted array 
	 * @return a sorted array of size left.length + right.length, consisting of all elements of arrays left and right.
	 * e.g., mergeSortedArrays({1, 3, 5, 7}, {2, 4, 6, 8}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 * You are forbidden to use the mergeSortedLists method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {

		if (left.length == 0 && right.length == 0) {
			int[] total = {};
			return total;
		} else if (left.length == 0 && right.length != 0) {
			return right;
		} else if (left.length != 0 && right.length == 0) {
			return left;
		} else {
			int[] total = Arrays.copyOf(left, left.length);
			total = mergeSortedArraysHelper(total, 0, right.length - 1, right);
			return total;
		}

	}
	
	private int[] mergeSortedArraysHelper(int[] array, int from, int to, int[] right) {

		if (from > to) {
			return array;
		}

		array = insertIntoSortedArray(array, right[from]);
		array = mergeSortedArraysHelper(array, from + 1, to, right);
		return array;
	}
	
	/**
	 * Given two sorted lists left and right, 
	 * return a sorted list of size left.size() + right.size(), 
	 * consisting of all elements of lists left and right.
	 * @param left a sorted list
	 * @param right a sorted list 
	 * @return a sorted list of size left.size() + right.size(), consisting of all elements of lists left and right.
	 * e.g., mergeSortedLists({1, 3, 5, 7}, {2, 4, 6, 8}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 * You are forbidden to use the mergeSortedArrays method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {

		if (left.size() == 0 && right.size() == 0) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			return list;
		} else if (left.size() == 0 && right.size() != 0) {
			return right;
		} else if (left.size() != 0 && right.size() == 0) {
			return left;
		} else {
			List<Integer> list = new ArrayList<Integer>(left);
			list = mergeSortedListsHelper(list, 0, right.size() - 1, right);
			return list;
		}

	}
	
	private List<Integer> mergeSortedListsHelper(List<Integer> list1, int from, int to, List<Integer> right) {

		if (from > to) {
			return list1;
		}

		list1 = insertIntoSortedList(list1, right.get(from));
		list1 = mergeSortedListsHelper(list1, from + 1, to, right);
		return list1;
	}
	
}
