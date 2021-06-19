package org.assessments.dp;

public class FibonacciNumber {

	private FibonacciNumber() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int n = 6;
		System.out.println(String.format("Fibonacci %d: %d", n, fib(n)));
	}

	public static int fib(int n) {
		// trivial case.
		if (n < 2)
			return n;
		int beforePrev = 0;
		int prev = 1;
		for (int i = 2; i <= n; i++) {
			final int tmp = beforePrev + prev;
			// then, swap it.
			beforePrev = prev;
			prev = tmp;
		}
		return prev;
	}
}
