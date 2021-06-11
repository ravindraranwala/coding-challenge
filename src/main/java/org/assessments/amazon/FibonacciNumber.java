package org.assessments.amazon;

public class FibonacciNumber {

	private FibonacciNumber() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int n = 0;
		System.out.println(String.format("Fibonacci %d: %d", n, fib(n)));
	}

	public static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		final int[] fibSeries = new int[n];
		fibSeries[0] = 0;
		fibSeries[1] = 1;
		for (int i = 2; i < n; i++)
			fibSeries[i] = fibSeries[i - 1] + fibSeries[i - 2];
		return fibSeries[n - 1] + fibSeries[n - 2];
	}
}
