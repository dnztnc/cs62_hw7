package autocomplete;

/**
 * Class of methods to find first and last match of an item in a list sorted by
 * a given comparator.
 * @author TODO
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
		// TODO: implement binary search for first index of item in aList using
		// comparator
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
		// TODO: implement binary search for last index of item in aList using
		// comparator
		return NOT_FOUND;
	}

	/**
	 * Method to test binary search operations.
	 *
	 * @param args ignored
	 */
	public static void main(String[] args) {
		// TODO: add tests for binary search methods
	}

}
