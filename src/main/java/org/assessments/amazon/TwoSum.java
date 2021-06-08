package org.assessments.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	private TwoSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums = { 3, 2, 4 };
		final int target = 6;
		final int[] indices = twoSum(nums, target);
		System.out.println(Arrays.toString(indices));
	}

	public static int[] twoSum(int[] nums, int target) {
		final Map<Integer, Integer> valToIdx = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (valToIdx.containsKey(target - nums[i]))
				return new int[] { i, valToIdx.get(target - nums[i]) };
			else
				valToIdx.put(nums[i], i);

		}
		return new int[0];
	}

}
