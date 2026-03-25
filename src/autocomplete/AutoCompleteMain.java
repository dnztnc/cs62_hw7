package autocomplete;

/**
 * Program to autocomplete a prefix typed in by user in a file consisting
 * of entries and associated numbers, where number is provided before
 * the entry. The program takes a parameter k as a run-time argument
 * and prompts the user to provide a file to be searched. The user
 * is prompted to enter a prefix in the console. The program then
 * prints in the console the k most popular matches according to
 * the numbers associated with each matching entry. The program
 * continues prompting the user for more prefixes until the user types
 * control-D or otherwise halts the program.
 *
 * @author Deniz Tanaci
 **/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutoCompleteMain {
	public static void main(String[] args) {
		if (args == null || args.length < 2) {
			System.err.println("missing arguments");
			return;
		}

		int k;
		try {
			k = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.err.println("first argument must be an integer");
			return;
		}

		String filename = args[1];

		List<Term> terms = new ArrayList<>();
		try (Scanner fileScanner = new Scanner(new File(filename), "utf-8")) {
			int n = fileScanner.nextInt();
			for (int i = 0; i < n; i++) {
				long weight = fileScanner.nextLong();
				String lineRemainder = fileScanner.nextLine();
				String key = lineRemainder.trim();
				terms.add(new Term(key, weight));
			}
		} catch (FileNotFoundException e) {
			System.err.println("Could not find file: " + filename);
			return;
		}

		Autocomplete autocomplete = new Autocomplete(terms);

		try (Scanner stdinScanner = new Scanner(System.in)) {
			while (true) {
				System.out.print("Enter a new prefix: ");
				if (!stdinScanner.hasNextLine()) {
					break;
				}

				String prefix = stdinScanner.nextLine().trim();
				List<Term> matches = autocomplete.allMatches(prefix);
				System.out.println("There are " + matches.size() + " matches.");

				if (matches.size() >= k) {
					System.out.println("The " + k + " largest are:");
					for (int i = 0; i < k; i++) {
						System.out.println(matches.get(i));
					}
				} else {
					System.out.println("The matching items are:");
					for (Term t : matches) {
						System.out.println(t);
					}
				}
			}
		}
	}

}
