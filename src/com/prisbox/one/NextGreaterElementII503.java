/**
 * 
 */
package com.prisbox.one;

/**
 * @author LO
 *
 */
public class NextGreaterElementII503 {
	public static int[] nextGreaterElements(int[] nums) {
		if (nums.length == 0) {
			return new int[0];
		}
		if (nums.length == 1) {
			return new int[] { -1 };
		}

		int[] re = new int[nums.length * 2];
		re[nums.length * 2 - 1] = -1;
		int length = nums.length;
		for (int i = re.length - 1; i > 0; i--) {
			int t = i % length;
			int l = (i - 1) % length;
			if (nums[t] > nums[l]) {
				re[i - 1] = i;
			} else {
				int ind = re[i];
				re[i - 1] = -1;
				while (ind != -1) {
					if (nums[ind % length] > nums[l]) {
						re[i - 1] = ind;
						break;
					} else {
						ind = re[ind];
					}
				}
			}
		}
		int[] result = new int[nums.length];

		for (int i = 0; i < result.length; i++) {
			if (re[i] != -1) {
				result[i] = nums[re[i]%length];
			} else {
				result[i] = -1;
			}
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 4,2,7,9,6,3,5,1,8 };
		NextGreaterElementII503.nextGreaterElements(nums);
	}

}
