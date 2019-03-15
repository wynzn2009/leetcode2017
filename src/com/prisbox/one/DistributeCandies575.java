package com.prisbox.one;

import java.util.HashSet;

public class DistributeCandies575 {
	public int distributeCandies(int[] candies) {
		int max = (candies.length + 1) / 2;
		HashSet<Integer> set = new HashSet<>();
		for (Integer i : candies) {
			set.add(i);
		}
		return Math.min(max, set.size());
	}

	public static void main(String[] args) {
		System.out.println("Hello world");
	}
}