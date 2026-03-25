package autocomplete;

/** Class to create objects that can find all items matching a prefix
 * @author: Deniz Tanaci
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
		// sort list of terms based on natural ordering
		this.terms=terms;
		Collections.sort(terms);
	}

	/**
	 * @param prefix String prefix to be matched
	 *
	 * @return list of terms that start with the given prefix, in descending
	 *         order of weight
	 */
	public List<Term> allMatches(String prefix) {
		List<Term> matching = new ArrayList<Term>();

		// make a new term with the given prefix and a default weight of 1
		Term prefixTerm = new Term(prefix, 1);
		// Continue by searching the list terms for the first and last index of matching
		// terms for the
		// first prefix.length() characters
		int firstIndex = BinarySearchForAll.firstIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefix.length()));
		// If any matches were found, copy ALL matching terms into matching
		// and sort it byReverseWeightOrder
		if (firstIndex != BinarySearchForAll.NOT_FOUND) {
			int lastIndex = BinarySearchForAll.lastIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefix.length()));
			for (int i = firstIndex; i <= lastIndex; i++) {
				matching.add(terms.get(i));
			}
			matching.sort(Term.byReverseWeightOrder());
		}
		return matching;
	}

	/**
	 * Test to make sure Autocomplete works correctly
	 *
	 * @param args ignored
	 *
	 */
	public static void main(String[] args) {
		// test the Autocomplete class
		List<Term> terms = new ArrayList<Term>();
		terms.add(new Term("apple", 100));
		terms.add(new Term("app", 80));
		terms.add(new Term("apricot", 120));
		terms.add(new Term("banana", 90));
		Autocomplete autocomplete = new Autocomplete(terms);
		System.out.println("Matches for 'ap': " + autocomplete.allMatches("ap"));
		System.out.println("Matches for 'app': " + autocomplete.allMatches("app"));
		System.out.println("Matches for 'b': " + autocomplete.allMatches("b"));
		System.out.println("Matches for 'c': " + autocomplete.allMatches("c"));

	}
}
