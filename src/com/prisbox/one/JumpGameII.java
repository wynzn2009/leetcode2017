/**
 * 
 */
package com.prisbox.one;

/**
 * @author admin
 *
 */
public class JumpGameII {
	public int jump(int[] nums) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + nums[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGameII j = new JumpGameII();
		int[] t = {2,3,1,1,4};
		j.jump(t);
	}

}
