package autocomplete;

/** Class to create objects that can find all items matching a prefix
 * @author: TODO
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Autocomplete {
	// list of terms (value and weight) that can be searched
	private List<Term> terms;

	/**
	 * Initializes the data structure from the given array of terms.
	 *
	 * @param terms List of terms that can be searched
	 */
	public Autocomplete(List<Term> terms) {
		// TODO: instantiation of list of terms
		// TODO: sort list of terms based on natural ordering
	}

	/**
	 * @param prefix String prefix to be matched
	 *
	 * @return list of terms that start with the given prefix, in descending
	 *         order of weight
	 */
	public List<Term> allMatches(String prefix) {
		List<Term> matching = new ArrayList<Term>();

		// TODO: make a new term with the given prefix and a default weight of 1
		// Continue by searching the list terms for the first and last index of matching
		// terms for the
		// first prefix.length() characters
		// If any matches were found, copy ALL matching terms into matching
		// and sort it byReverseWeightOrder

		return matching;
	}

	/**
	 * Test to make sure Autocomplete works correctly
	 *
	 * @param args ignored
	 *
	 */
	public static void main(String[] args) {
		// TODO: test the Autocomplete class
	}
}
