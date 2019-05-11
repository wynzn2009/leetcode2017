/**
 * 
 */
package com.prisbox.one;

/**
 * @author admin
 *
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int t = nums[i];
			if (t == i + 1) {
				continue;
			}
			if (t > nums.length) {
				nums[i] = 0;
				continue;
			} else if (t > 0 && t != nums[t - 1]) {
				nums[i] = nums[i] ^ nums[t - 1];
				nums[t - 1] = nums[i] ^ nums[t - 1];
				nums[i] = nums[i] ^ nums[t - 1];
				i--;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
