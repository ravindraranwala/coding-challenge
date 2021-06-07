package org.assessments.amazon;

import java.util.Arrays;

/**
 * Question: You are on a flight and wanna watch two movies during this flight.
 * You are given List<Integer> movieDurations which includes all the movie
 * durations. You are also given the duration of the flight which is d in
 * minutes. Now, you need to pick two movies and the total duration of the two
 * movies is less than or equal to (d - 30min).
 * 
 * Find the pair of movies with the longest total duration and return they
 * indexes. If multiple found, return the pair with the longest movie.
 * 
 * Example 1:
 * 
 * Input: movieDurations = [90, 85, 75, 60, 120, 150, 125], d = 250 Output: [0,
 * 6] Explanation: movieDurations[0] + movieDurations[6] = 90 + 125 = 215 is the
 * maximum number within 220 (250min - 30min)
 * 
 * 
 * Problem statement can be found here:
 * https://leetcode.com/discuss/interview-question/313719/Amazon-or-Online-Assessment-2019-or-Movies-on-Flight
 * 
 * @author ravindra
 *
 */
public class MoviesOnFlight {
	private MoviesOnFlight() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] movieDurations = { 90, 85, 75, 60, 120, 150, 125 };
		final int d = 250;
		final int takeOffAndLandingTime = 30;

		final int[] movies = twoSum(movieDurations, d - takeOffAndLandingTime);
		System.out.println(Arrays.toString(movies));
	}

	public static int[] twoSum(int[] nums, int target) {
		if (nums.length < 2)
			throw new IllegalArgumentException("Array should contain at least two elements.");
		final int[] numbers = nums.clone();
		Arrays.sort(numbers);
		int firstIdx = 0;
		int secondIdx = 0;
		int closestSum = Integer.MIN_VALUE;

		for (int low = 0, high = numbers.length - 1; low < high;) {
			final int currentTotal = numbers[low] + numbers[high];
			if (currentTotal <= target) {
				if (currentTotal > closestSum) {
					firstIdx = low;
					secondIdx = high;
					closestSum = currentTotal;
				}
				low++;
			} else
				high--;

		}

		final int[] indices = { -1, -1 };
		for (int i = 0; i < nums.length && indices[0] == -1; i++)
			if (numbers[firstIdx] == nums[i])
				indices[0] = i;

		for (int i = nums.length - 1; i >= 0 && indices[1] == -1; i--)
			if (numbers[secondIdx] == nums[i])
				indices[1] = i;

		return indices;
	}
}
