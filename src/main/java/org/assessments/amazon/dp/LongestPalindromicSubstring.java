package org.assessments.amazon.dp;

class LongestPalindromicSubstring {
	LongestPalindromicSubstring() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String s = "aaaa";
		final String p = longestPalindrome(s);
		System.out.println(p);
	}

	public static String longestPalindrome(String s) {
		if(s.isEmpty())
			return s;

		final int n = s.length();
		final int[][] l = new int[n][n];
		int start = -1;
		for (int i = 0; i < n; i++) {
			l[i][i] = 1;
			start = i;
		}

		for (int len = 2; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				final int j = i + len - 1;
				if (s.charAt(i) == s.charAt(j) && (len == 2 || l[i + 1][j - 1] == len - 2)) {
					l[i][j] = len;
					start = i;
				} else if (l[i][j - 1] >= l[i + 1][j]) {
					l[i][j] = l[i][j - 1];
				} else {
					l[i][j] = l[i + 1][j];
				}
			}
		}
		return s.substring(start, start + l[0][n - 1]);
	}

}