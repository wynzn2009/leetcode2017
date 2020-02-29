/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LO 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n
 *         的数组 groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
 * 
 *         你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
 * 
 *          
 * 
 *         示例 1：
 * 
 *         输入：groupSizes = [3,3,3,3,3,1,3] 输出：[[5],[0,1,2],[3,4,6]] 解释：
 *         其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。 示例 2：
 * 
 *         输入：groupSizes = [2,1,3,3,3,2] 输出：[[1],[0,5],[2,3,4]]  
 * 
 *         提示：
 * 
 *         groupSizes.length == n 1 <= n <= 500 1 <= groupSizes[i] <= n
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/group-the-people-given-the-group-size-they-belong-to
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupthePeopleGiventheGroupSizeTheyBelongTo1282 {
	public static List<List<Integer>> groupThePeople(int[] groupSizes) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < groupSizes.length; i++) {
			if (groupSizes[i] == 1) {
				List<Integer> l = List.of(i);
				re.add(l);
				continue;
			}
			if (map.containsKey(groupSizes[i])) {
				List<Integer> l = map.get(groupSizes[i]);
				l.add(i);
				if (l.size() == groupSizes[i]) {
					re.add(l);
					map.remove(groupSizes[i]);
				}
			} else {
				List<Integer> l = new ArrayList<>(groupSizes[i]);
				l.add(i);
				map.put(groupSizes[i], l);
			}
		}
		return re;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 3, 3, 3, 3, 3, 1, 3 };
		GroupthePeopleGiventheGroupSizeTheyBelongTo1282.groupThePeople(a);
	}

}
