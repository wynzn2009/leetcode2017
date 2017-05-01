/**
 * 
 */
package com.prisbox.one;

/**
 * @author LO
 *
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if(nums.length==1){
			return nums[0];
		}
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        int tempMax;
        int tempMin;
        for(int i=1;i<nums.length;i++){
        	tempMax = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
        	tempMin = Math.min(Math.min(max*nums[i], min*nums[i]), nums[i]);
        	result = Math.max(result, tempMax);
        	max = tempMax;
        	min = tempMin;
        }
		return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
