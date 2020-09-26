/**
 * 
 */
package com.prisbox.one;

import java.util.Arrays;

/**
 * @author wynzn 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * 
 *         示例 1:
 * 
 *         输入: [2,2,3,4] 输出: 3 解释: 有效的组合是: 2,3,4 (使用第一个 2) 2,3,4 (使用第二个 2) 2,2,3
 *         注意:
 * 
 *         数组长度不超过1000。 数组里整数的范围为 [0, 1000]。
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/valid-triangle-number
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidTriangleNumber611 {
	public int triangleNumber(int[] nums) {
		Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = n - 1; i >= 2; --i) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
