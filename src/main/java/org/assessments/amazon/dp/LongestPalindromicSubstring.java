package org.assessments.amazon.dp;

class LongestPalindromicSubstring {
	LongestPalindromicSubstring() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String s = "cbbd";
		final String p = longestPalindrome(s);
		System.out.println(p);
	}

	public static String longestPalindrome(String s) {
		if (s.isEmpty())
			return "";

		final int n = s.length();
		final int[][] l = new int[n][n];
		final int[][] start = new int[n][n];

		for (int i = 0; i < n; i++) {
			l[i][i] = 1;
			start[i][i] = i;
		}

		for (int len = 2; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				final int j = i + len - 1;
				if (s.charAt(i) == s.charAt(j) && (len == 2 || l[i + 1][j - 1] == len - 2)) {
					l[i][j] = len;
					start[i][j] = i;
				} else if (l[i][j - 1] >= l[i + 1][j]) {
					l[i][j] = l[i][j - 1];
					start[i][j] = start[i][j - 1];
				} else {
					l[i][j] = l[i + 1][j];
					start[i][j] = start[i + 1][j];
				}
			}
		}
		return s.substring(start[0][n - 1], start[0][n - 1] + l[0][n - 1]);
	}

}
