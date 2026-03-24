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

	// TODO: Fill any instance variables

	/**
	 * Initializes a term with the given key and weight.
	 *
	 * @param key    key to be stored
	 * @param weight associated weight
	 */
	public Term(String key, long weight) {
		// TODO: fill in constructor
	}

	/**
	 * @return comparator ordering elements by descending weight
	 */
	public static Comparator<Term> byReverseWeightOrder() {
		// TODO: implement and return appropriate comparator
		return null;
	}

	/**
	 * @param r Number of initial characters to use in comparing keys
	 *
	 * @return comparator using lexicographic order, but using only the first r
	 *         letters of each key
	 */
	public static Comparator<Term> byPrefixOrder(int r) {
		// TODO: implement and return appropriate comparator
		return null;
	}

	/**
	 * @param that Term to be compared
	 *
	 * @return -1, 0, or 1 depending on whether the key for THIS is
	 *         lexicographically smaller, same or larger than THAT
	 */
	public int compareTo(Term that) {
		// TODO: implement natural comparison
		return 0;
	}

	/**
	 * @return a string representation of this term in the following format: the
	 *         weight, followed by 2 tabs, followed by the key.
	 **/
	public String toString() {
		// TODO: return appropriate string
		return null;
	}

}
