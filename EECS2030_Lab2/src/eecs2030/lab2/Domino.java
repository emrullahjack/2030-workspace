package eecs2030.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents domino tiles. A domino is a rectangular
 * tile with a line dividing its playing face into two sides.
 * Each side of the playing face is marked with pips (dots) similar
 * to a standard 6-sided die. The number of pips on each side
 * of the playing face ranges from Domino.MIN_VALUE to
 * Domino.MAX_VALUE (inclusive).
 * 
 * <p>
 * In simpler terms, each domino tile has two integer values
 * that range from Domino.MIN_VALUE to Domino.MAX_VALUE (inclusive).
 *
 */
public class Domino implements Comparable<Domino> {

	// YOU NEED TO ADD SOME public static final FIELDS HERE
	
	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 6;
	
	// YOU NEED TO ADD SOME FIELDS FOR THE STATE OF A DOMINO HERE
	
	public int value1;
	public int value2;

	/**
	 * Initializes this domino so that both of its values are
	 * equal to <code>Domino.MIN_VALUE</code>.
	 */
	public Domino() {
		value1 = MIN_VALUE;
		value2 = MIN_VALUE;
	}

	/**
	 * Initializes this domino to have the specified values.
	 * 
	 * @param value1
	 *            a value
	 * @param value2
	 *            another value
	 * @pre. Domino.isValueOK(value1) && Domino.isValueOK(value2)
	 * @throws IllegalArgumentException
	 *             if value1 or value2 is not a legal domino value
	 */
	public Domino(int value1, int value2) throws IllegalArgumentException {

		if (isValueOK(value1) == false || isValueOK(value2) == false) {
			throw new IllegalArgumentException();
		} else {
			this.value1 = value1;
			this.value2 = value2;
		}

	}

	/**
	 * Initializes this domino so that its values are the same as the specified
	 * other domino.
	 * 
	 * @param other
	 *            a domino
	 */
	public Domino(Domino other) {
		this.value1 = other.value1;
		this.value2 = other.value2;
	}

	/**
	 * Returns true if the specified value is a legal domino value, and false
	 * otherwise.
	 * 
	 * @param value
	 *            a value to check
	 * @return true if the specified value is a legal domino value, and false
	 *         otherwise
	 */
	public static boolean isValueOK(int value) {
		boolean result = false;

		if (MIN_VALUE <= value && value <= MAX_VALUE) {
			result = true;
		}

		return result;
	}

	/**
	 * Returns a list of size 28 containing all of the tiles of the double-six
	 * set (see test document for details).
	 * 
	 * @return a list of size 28 containing all of the tiles of the double-six
	 *         set
	 */
	public static List<Domino> allDominoes() {
		ArrayList<Domino> dominoList = new ArrayList<>();
		Domino dominoToPut;

		for (int v1 = 0; v1 <= MAX_VALUE; v1++) {

			for (int v2 = v1; v2 <= MAX_VALUE; v2++) {
				dominoToPut = new Domino(v1, v2);
				dominoList.add(dominoToPut);
			}

		}

		return dominoList;
	}
	
	/**
	 * Returns the value of one of the two sides of the domino (the value of the
	 * other side of the domino is returned by <code>getValue2</code>).
	 * 
	 * @return the value of one of the two sides of the domino
	 */
	public int getValue1() {
		return value1;
	}

	/**
	 * Returns the value of one of the two sides of the domino (the value of the
	 * other side of the domino is returned by <code>getValue1</code>).
	 * 
	 * @return the value of one of the two sides of the domino
	 */
	public int getValue2() {
		return value2;
	}

	/**
	 * Returns the smaller of the two values of this domino. If both
	 * values of this domino are equal to the same value then that
	 * value is returned.
	 * 
	 * @return the smaller of the two values of this domino
	 */
	public int getSmallerValue() {
		int smallerValue = value1;

		if (value2 < value1) {
			smallerValue = value2;
		}

		return smallerValue;
	}

	/**
	 * Returns the larger of the two values of this domino. If both
	 * values of this domino are equal to the same value then that
	 * value is returned.
	 * 
	 * @return the larger of the two values of this domino
	 */
	public int getLargerValue() {
		int largerValue = value1;

		if (value2 > value1) {
			largerValue = value2;
		}

		return largerValue;
	}

	
	/**
	 * Returns true if this domino matches the specified domino, and
	 * false otherwise.
	 *
	 * <p>
	 * Two dominoes match if they have at least one value in common.
	 * Note that the side on which
	 * a value appears is not considered for the purposes of matches;
	 * for instance, <code>m</code> will be true in the example below:
	 * 
	 * <pre>
	 * Domino a = new Domino(1, 4);
	 * Domino b = new Domino(4, 2);  // a and b have the value 4 in common
	 * boolean m = a.matches(b);
	 * </pre>
	 * 
	 * @param other a domino
	 * @return true if this domino matches the specified domino,
	 *         and false otherwise
	 */
	public boolean matches(Domino other) {
		boolean result = true;

		if ((this.value1 != other.value1 && this.value1 != other.value2)
				&& (this.value2 != other.value1 && this.value2 != other.value2)) {
			result = false;
		}

		return result;
	}
	
	/**
	 * Compares two dominoes by their values. The smaller values on
	 * the two dominoes are compared first; if the smaller values of
	 * both dominoes are equal then the larger values of the two
	 * dominoes are compared.
	 * 
	 * <p>
	 * If the two dominoes are equal then {@code 0} is returned.
	 * 
	 * <p>
	 * This domino is less than the other domino if the smaller value
	 * of this domino is less than the smaller value of the other
	 * domino, or if the larger value of this domino is less than
	 * the larger value of the other domino and the smaller values
	 * of both dominoes are equal.
	 * 
	 * <p>
	 * This domino is greater than the other domino if the smaller value
	 * of this domino is greater than the smaller value of the other
	 * domino, or if the larger value of this domino is greater than
	 * the larger value of the other domino and the smaller values
	 * of both dominoes are equal.
	 * 
	 * @param other the other domino to compare to this domino
	 * @return the value 0 if this domino is equal to other;
	 * a value less than 0 if this domino is less than the other
	 * domino; and a value greater than 0 if this domino is greater than
	 * the other domino 
	 */
	@Override
	public int compareTo(Domino other) {
		int result;

		if (this.getSmallerValue() == other.getSmallerValue()) {

			if (this.getLargerValue() == other.getLargerValue()) {
				result = 0;
			} else if (this.getLargerValue() < other.getLargerValue()) {
				result = -1;
			} else {
				result = 1;
			}

		} else if (this.getSmallerValue() < other.getSmallerValue()) {
			result = -1;
		} else {
			result = 1;
		}

		return result;
	}
	
	/**
	 * Compares this domino to the specified object. The result is
	 * true if and only if the argument is a Domino object having the
	 * same values as this domino object. Note that the side on which
	 * a value appears is not considered for the purposes of equals;
	 * for instance, <code>eq</code> will be true in the example below:
	 * 
	 * <pre>
	 * Domino a = new Domino(1, 4);
	 * Domino b = new Domino(4, 1);
	 * boolean eq = a.equals(b);
	 * </pre>
	 * 
	 * @param obj an object to compare
	 * @return true if this domino is equal to the specified object,
	 *         and false otherwise
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		} else if (obj == null || (this.getClass() != obj.getClass())) {
			return false;
		} else {
			Domino other = (Domino) obj;
			return ((this.value1 == other.value1) && (this.value2 == other.value2))
					|| ((this.value1 == other.value2) && (this.value2 == other.value1));
		}

	}
	
	
	/**
	 * Returns a hash code for this domino. The hash code value
	 * is equal to the smaller value of this domino plus eleven times
	 * the larger value of this domino.
	 * 
	 * @return the smaller value of this domino plus eleven times
	 * the larger value of this domino
	 */
	@Override
	public int hashCode() {	
		return getSmallerValue() + (11 * getLargerValue());
	}
	
	/**
	 * Returns a string representation of this domino. The returned
	 * string is the smaller value of this domino followed by
	 * a space, a colon, a space, and finally the larger value of
	 * this domino all inside a pair of square brackets; for example,
	 * if {@code d = new Domino(5, 3)} then {@code d.toString()} returns
	 * the string {@code "[3 : 5]"}.  
	 * 
	 * @return a string representation of this domino
	 */
	@Override
	public String toString() {
		return "[" + getSmallerValue() + " : " + getLargerValue() + "]";
	}
	
}