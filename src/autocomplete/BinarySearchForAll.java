package autocomplete;

/**
 * Class of methods to find first and last match of an item in a list sorted by
 * a given comparator.
 * @author Deniz Tanaci
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchForAll {
	// flag indicating whether an item occurs at all in the list
	public static final int NOT_FOUND = -1;

	/**
	 * Returns the index of the first element in aList that equals item
	 *
	 * @param aList      Ordered (via specified comparator) list of items to be
	 *                   searched
	 * @param item       item searching for
	 * @param comparator Object with compare method corresponding to order on aList
	 *
	 * @return Index of first item in aList matching item or -1 if not in aList
	 **/
	public static <Item> int firstIndexOf(List<Item> aList, Item item, Comparator<Item> comparator) {
		// implement binary search for first index of item in aList using
		// comparator
		int low = 0;
		int high = aList.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int result = comparator.compare(item, aList.get(mid));
			if (result < 0) {
				high = mid - 1;
			} else if (result > 0) {
				low = mid + 1;
			} else {
				if (mid == low || comparator.compare(item, aList.get(mid - 1)) != 0) {
					return mid;
				}
				high = mid - 1;
			}
		}
		return NOT_FOUND;
	}

	/**
	 * Returns the index of the last element in aList that equals item
	 *
	 * @param aList      Ordered (via specified comparator) list of items to be
	 *                   searched
	 * @param item       item searching for
	 * @param comparator Object with compare method corresponding to order on aList
	 *
	 * @return Location of last item of aList matching item or -1 if no such item.
	 **/
	public static <Item> int lastIndexOf(List<Item> aList, Item item, Comparator<Item> comparator) {
		// implement binary search for last index of item in aList using
		// comparator
		int low = 0;
		int high = aList.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int result = comparator.compare(item, aList.get(mid));
			if (result < 0) {
				high = mid - 1;
			} else if (result > 0) {
				low = mid + 1;
			} else {
				if (mid == high || comparator.compare(item, aList.get(mid + 1)) != 0) {
					return mid;
				}
				low = mid + 1;
			}
		}
		return NOT_FOUND;
	}

	/**
	 * Method to test binary search operations.
	 *
	 * @param args ignored
	 */
	public static void main(String[] args) {
		// some tests
		Term t1 = new Term("apricot", 10);
		Term t2 = new Term("banana", 20);
		Term t3 = new Term("apple", 15);
		Term t4 = new Term("aaan", 5);
		List<Term> list = new ArrayList<>();
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		Collections.sort(list, Term.byPrefixOrder(2));
		System.out.println("Sorted by 2-letter prefix: " + list);
		System.out.println("First index of 'ap': " + firstIndexOf(list, new Term("ap", 0), Term.byPrefixOrder(2)));
		System.out.println("Last index of 'ap': " + lastIndexOf(list, new Term("ap", 0), Term.byPrefixOrder(2)));
		System.out.println(t1);

	}

}
