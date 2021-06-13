package org.assessments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OrderPrioritization {
	private static Pattern FIRST_SPACE = Pattern.compile("(^[\\da-zA-Z]*)\\s(.*)");
	private static Pattern PRIME_META = Pattern.compile("[a-zA-Z ]*");
//	private static Pattern NON_PRIME_META = Pattern.compile("^(?=.*\\d)[\\d\\s]*$");

	private OrderPrioritization() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String primeOne = "abc1 aa bb cc";
		final String primeTwo = "def1 bb cd";
		final String nonPrimeOne = "abef1 12 4";
		final String nonPrimeTwo = "abc1 11 2";

		final String[] orders = { primeTwo, nonPrimeTwo, primeOne, nonPrimeOne };
		System.out.println(Arrays.toString(orders));
		Arrays.sort(orders, OrderPriority.of());
		System.out.println(Arrays.toString(orders));
		
		// expected result: abc1 aa bb cc, def1 bb cd, abc1 11 2, abef1 12 4
		final String expected = "[abc1 aa bb cc, def1 bb cd, abc1 11 2, abef1 12 4]";
		assert expected.equals(Arrays.toString(orders));
	}

	public static void orderPrioritization(String[] orders) {
		Arrays.sort(orders, OrderPriority.of());
	}

	static class OrderPriority implements Comparator<String> {
		private OrderPriority() {

		}

		public static OrderPriority of() {
			return new OrderPriority();
		}

		@Override
		public int compare(String o1, String o2) {
			final Matcher o1Matcher = FIRST_SPACE.matcher(o1);
			final Matcher o2Matcher = FIRST_SPACE.matcher(o2);
			// Extract the data first.
			String o1Id = "";
			String o2Id = "";
			String o1MetaData = "";
			String o2MetaData = "";

			if (o1Matcher.matches()) {
				o1Id = o1Matcher.group(1);
				o1MetaData = o1Matcher.group(2);
			}
			if (o2Matcher.matches()) {
				o2Id = o2Matcher.group(1);
				o2MetaData = o2Matcher.group(2);
			}

			final boolean isO1Prime = PRIME_META.matcher(o1MetaData).matches();
			final boolean isO2Prime = PRIME_META.matcher(o2MetaData).matches();
			// then do the comparison.
			if (isO1Prime && isO2Prime) {
				int position = o1MetaData.compareTo(o2MetaData);
				return position != 0 ? position : o1Id.compareTo(o2Id);
			} else if (isO1Prime && !isO2Prime)
				return -1;
			else if (!isO1Prime && isO2Prime)
				return 1;
			else
				return 0; // keeps the original ordering if both are non-prime orders.
		}

	}

}
