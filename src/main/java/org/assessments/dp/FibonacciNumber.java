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
		final int[] fibSeries = new int[2];
		fibSeries[0] = 0;
		fibSeries[1] = 1;
		for (int i = 2; i <= n; i++)
		{
			final int f = fibSeries[0] + fibSeries[1];
			// then, swap it.
			fibSeries[0] = fibSeries[1];
			fibSeries[1] = f;
		}
		return fibSeries[1];
	}
}
