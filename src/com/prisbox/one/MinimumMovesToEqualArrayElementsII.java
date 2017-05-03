/**
 * 
 */
package com.prisbox.one;

import java.util.Arrays;

/**
 * @author admin
 *
 */
public class MinimumMovesToEqualArrayElementsII {
	public int minMoves2(int[] nums) {
        if(nums.length==1){
        	return 0;
        }
        Arrays.sort(nums);
        int index = 0;
        int mid = (nums.length-1)/2;
        int length = nums.length;
        int sum = 0;
        while(index<=mid){
        	sum += nums[length-index-1]-nums[index];
        	index++;
        }
		return sum;
    }
	
	public int minMoves21(int[] nums) {
        if(nums.length==1){
        	return 0;
        }
        Arrays.sort(nums);
		int mid = nums[(nums.length-1)/2];
		int sum = 0;
		for(int t : nums){
			sum += Math.abs(t-mid);
		}
		return sum;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumMovesToEqualArrayElementsII m = new MinimumMovesToEqualArrayElementsII();
		int[] a = {1};
		m.minMoves2(a);
	}

}
