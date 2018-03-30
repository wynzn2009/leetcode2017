/**
 * 
 */
package com.prisbox.one;

import java.util.Arrays;

/**
 * @author admin
 *
 */
//TODO 更快的要求
public class WiggleSortII324 {
	public static void wiggleSort(int[] nums) {
		if(nums==null||nums.length<2){
			return;
		}
		int[] t = Arrays.copyOf(nums, nums.length);
		Arrays.sort(t);
		
		int i=0;
		int plus = (nums.length+1)/2;
		int m =plus;
		while(i<nums.length){
			nums[i] = t[m-1];
			if(i+1<nums.length){
				nums[i+1] = t[nums.length-1-plus+m];
			}
			i+=2;
			m--;
		}
    }
	/*private static void change(int[] nums ,int start,int end){
		nums[start] = nums[start]^nums[end];
		nums[end] = nums[start]^nums[end];
		nums[start] = nums[start]^nums[end];
	}*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,5,1,1,6,4};
		wiggleSort(a);
	}

}
