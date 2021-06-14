package org.assessments.ms;

import java.util.HashSet;
import java.util.Set;

public class LargestK {

	public static void main(String[] args) {
		final int[] nums = { 3, 2, -2, 5, -3 };
		final int l = findLargestK(nums);
		System.out.println(l);
	}

	static int findLargestK(int[] num) {
		int largest = 0;
		final Set<Integer> intSet = new HashSet<>();
		for (int val : num) {
			intSet.add(val);
			if (intSet.contains(-1 * val))
				largest = Math.max(largest, Math.abs(val));
		}
		return largest;
	}
}
