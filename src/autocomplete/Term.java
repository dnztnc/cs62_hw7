package autocomplete;

/**
 * Class that represents a term which consists of a key and an associated
 * weight.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Term implements Comparable<Term> {

	// Fill any instance variables
	private final String key;
	private final long weight;

	/**
	 * Initializes a term with the given key and weight.
	 *
	 * @param key    key to be stored
	 * @param weight associated weight
	 */
	public Term(String key, long weight) {
		this.key = key;
		this.weight = weight;
	}

	/**
	 * @return comparator ordering elements by descending weight
	 */
	public static Comparator<Term> byReverseWeightOrder() {
		return (Term t1, Term t2) -> {
			return (Long.compare(t2.weight, t1.weight));
		};
	}

	/**
	 * @param r Number of initial characters to use in comparing keys
	 *
	 * @return comparator using lexicographic order, but using only the first r
	 *         letters of each key
	 */
	public static Comparator<Term> byPrefixOrder(int r) {
		return (Term t1, Term t2) -> {
			String s1 = t1.key.substring(0, Math.min(r, t1.key.length()));
			String s2 = t2.key.substring(0, Math.min(r, t2.key.length()));
			return s1.compareTo(s2);
		};
	}

	/**
	 * @param that Term to be compared
	 *
	 * @return -1, 0, or 1 depending on whether the key for THIS is
	 *         lexicographically smaller, same or larger than THAT
	 */
	public int compareTo(Term that) {
		return this.key.compareTo(that.key);
	}

	/**
	 * @return a string representation of this term in the following format: the
	 *         weight, followed by 2 tabs, followed by the key.
	 **/
	public String toString() {
		return this.weight + "\t\t" + this.key;
	}
	public static void main(String[] args) {	
		// some tests
		Term t1 = new Term("apricot", 10);
		Term t2 = new Term("banana", 20);
		Term t3 = new Term("apple", 15);
		
		List<Term> list = new ArrayList<>();
		list.add(t1);
		list.add(t2);
		list.add(t3);
		Collections.sort(list, Term.byPrefixOrder(3));
		System.out.println("Sorted by 3-letter prefix: " + list);
		Collections.sort(list, Term.byPrefixOrder(2));
		System.out.println("Sorted by 2-letter prefix: " + list);
		Collections.sort(list, Term.byReverseWeightOrder());
		System.out.println("Sorted by reverse weight order: " + list);

		System.out.println(Term.byPrefixOrder(3).compare(t1, t3));
		System.out.println(Term.byPrefixOrder(2).compare(t1, t3));


		System.out.println(t1);


	}
}
