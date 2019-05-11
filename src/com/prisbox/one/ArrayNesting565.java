/**
 * 
 */
package com.prisbox.one;

/**
 * @author admin
 *
 */
public class ArrayNesting565 {
	public static int arrayNesting(int[] nums) {
		int max = 0;
		int length = 0;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				continue;
			} else {
				index = nums[i];
				nums[i] = -1;
				while (index != i) {
					length++;
					int temp = index;
					index = nums[index];
					nums[temp] = -1;
				}
				max = Math.max(max, length + 1);
				length = 0;
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 5, 4, 0, 3, 1, 6, 2 };
		arrayNesting(a);
		System.out.println(12412);
	}

}
