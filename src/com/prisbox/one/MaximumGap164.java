/**
 * 
 */
package com.prisbox.one;

import java.util.Arrays;

/**
 * @author LO
 *
 */
public class MaximumGap164 {
    public int maximumGap(int[] nums) {
        if(nums==null||nums.length<2){
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(i!=nums.length-1){
                max = Math.max(max, nums[i+1]-nums[i]);
            }
        }
        return max;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
