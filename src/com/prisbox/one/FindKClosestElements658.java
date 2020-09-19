/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x
 * 的差值一样，优先选择数值较小的那个数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5], k=4, x=3 输出: [1,2,3,4]  
 * 
 * 示例 2:
 * 
 * 输入: [1,2,3,4,5], k=4, x=-1 输出: [1,2,3,4]  
 * 
 * 说明:
 * 
 * k 的值为正数，且总是小于给定排序数组的长度。 数组不为空，且长度不超过 104 数组里的每个元素与 x 的绝对值不超过 104
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-k-closest-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author wynzn
 *
 */
public class FindKClosestElements658 {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = arr.length - 1;
        while (end - start + 1 > k) {
            if (x - arr[start] > arr[end] - x) {
                start++;
            } else {
                end--;
            }
        }
        for (int i = start; i <= end; i++) {
            res.add(arr[i]);
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
