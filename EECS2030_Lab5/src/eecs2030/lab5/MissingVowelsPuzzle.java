package eecs2030.lab5;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * <p>
 * A word puzzle where the letters 'a', 'e', 'i', 'o', and 'u' are missing from
 * the puzzle word and replaced with an underscore '_'. For example:
 * </p>
 * 
 * <pre>
 * MissingVowelsPuzzle p = new MissingVowelsPuzzle("facetious");
 * System.out.println(p);
 * </pre>
 * 
 * <p>
 * outputs:
 * 
 * <p>
 * {@code f_c_t___s : facetious}
 * 
 * <p>
 * A second example where the puzzle has multiple solutions:
 * 
 * <pre>
 * MissingVowelsPuzzle p = new MissingVowelsPuzzle("cat", "cot", "cut");
 * System.out.println(p);
 * </pre>
 * 
 * <p>
 * outputs:
 * 
 * <p>
 * {@code c_t : cat, cot, cut}
 * 
 * 
 */
public class MissingVowelsPuzzle extends AbstractWordPuzzle {

	/**
	 * The set of solution words
	 */
	private SortedSet<String> solutions;

	/**
	 * Constructs a missing vowels word puzzle for the solution word
	 * {@code solution}. The puzzle word is the solution word with the
	 * letters 'a', 'e', 'i', 'o', and 'u' replaced with an underscore '_'.
	 * 
	 * @param solution
	 *            a solution word
	 */
	public MissingVowelsPuzzle(String solution) {
		super();
		solutions = new TreeSet<>();
		String s = new String(solution);
		solutions.add(s);
		s = s.replace('a', '_');
		s = s.replace('e', '_');
		s = s.replace('i', '_');
		s = s.replace('o', '_');
		s = s.replace('u', '_');
		this.setPuzzleWord(s);
	}

	/**
	 * Constructs a missing vowels word puzzle for the solution word
	 * {@code solution}. All other possible solutions should also be
	 * provided.
	 * 
	 * <p>
	 * The additional solutions provided in {@code otherSolutions} are
	 * checked to confirm that they produce the same puzzle word as
	 * {@code solution} and an exception is thrown if one or more of
	 * the words in {@code otherSolutions} does not produce the same
	 * puzzle word as {@code solution}
	 * 
	 * @param solution
	 *            a solution word
	 * @param otherSolutions
	 *            all other solutions to the puzzle
	 * @throws IllegalArgumentException
	 *             if a word in otherSolutions is incompatible
	 *             with solution
	 */
	public MissingVowelsPuzzle(String solution, String[] otherSolutions) throws IllegalArgumentException {
		super();
		String s = new String(solution);
		s = s.replace('a', '_');
		s = s.replace('e', '_');
		s = s.replace('i', '_');
		s = s.replace('o', '_');
		s = s.replace('u', '_');
		
		for (String otherSolution : otherSolutions) {
			String temporaryString = new String(otherSolution);
			temporaryString = temporaryString.replace('a', '_');
			temporaryString = temporaryString.replace('e', '_');
			temporaryString = temporaryString.replace('i', '_');
			temporaryString = temporaryString.replace('o', '_');
			temporaryString = temporaryString.replace('u', '_');
			
			if (!s.equals(temporaryString)) {
				throw new IllegalArgumentException();
			}
			
		}
		
		solutions = new TreeSet<>();
		solutions.add(new String(solution));
		
		for (String otherSolution : otherSolutions) {
			solutions.add(new String(otherSolution));
		}
		
		this.setPuzzleWord(s);		
	}

	/**
	 * Get the solution word. If there is more than one solution this method
	 * returns the solution that comes first in dictionary order.
	 * 
	 * @return the solution word that comes first in dictionary order
	 */
	@Override
	public String getSolution() {
		return solutions.first();
	}

	/**
	 * Get a sorted set of all of the solution words.
	 * 
	 * <p>
	 * The set returned by this method cannot be used to modify the solutions
	 * for this puzzle.
	 * 
	 * @return a sorted set of solution words
	 */
	@Override
	public SortedSet<String> getSolutions() {
		TreeSet<String> set = new TreeSet<>();
		
		for (String solution : solutions) {
			set.add(new String(solution));
		}
		
		return set;
	}

	/**
	 * Compute the puzzle word corresponding to a {@code solution} word.
	 * The puzzle word is the solution word with the letters 'a', 'e', 'i', 'o',
	 * and 'u' replaced with an underscore '_'.
	 * 
	 * @param solution
	 *            a solution word
	 * @return the puzzle word
	 */
	private static String computePuzzleWord(String solution) {
		String s = new String(solution);
		s = s.replace('a', '_');
		s = s.replace('e', '_');
		s = s.replace('i', '_');
		s = s.replace('o', '_');
		s = s.replace('u', '_');		
		return s;
	}
}
