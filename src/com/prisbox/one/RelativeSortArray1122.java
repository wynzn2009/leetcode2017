/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LO 给你两个数组，arr1 和 arr2，
 * 
 *         arr2 中的元素各不相同 arr2 中的每个元素都出现在 arr1 中 对 arr1 中的元素进行排序，使 arr1
 *         中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 
 *          
 * 
 *         示例：
 * 
 *         输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 *         输出：[2,2,2,1,4,3,3,9,6,7,19]
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/relative-sort-array
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RelativeSortArray1122 {
	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> l = new ArrayList();

		for (int i = 0; i < arr2.length; i++) {
			map.put(arr2[i], 0);
		}
		for (int i = 0; i < arr1.length; i++) {
			if (!map.containsKey(arr1[i])) {
				l.add(arr1[i]);
			} else {
				map.compute(arr1[i], (k, v) -> ++v);
			}
		}
		int ind = 0;
		for (int i = 0; i < arr2.length; i++) {
			int key = arr2[i];
			int count = map.get(key);
			for (; count > 0; count--) {
				arr1[ind++] = key;
			}
		}
		Collections.sort(l);
		for (int i = 0; i < l.size(); i++) {
			arr1[ind++] = l.get(i);
		}

		return arr1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
		int[] arr2 = { 2, 1, 4, 3, 9, 6 };
		RelativeSortArray1122.relativeSortArray(arr1, arr2);
	}

}
