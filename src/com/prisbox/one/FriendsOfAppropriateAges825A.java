/**
 * 
 */
package com.prisbox.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 015422404 人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。
 * 
 *         当满足以下条件时，A 不能给 B（A、B不为同一人）发送好友请求：
 * 
 *         age[B] <= 0.5 * age[A] + 7 age[B] > age[A] age[B] > 100 && age[A] <
 *         100 否则，A 可以给 B 发送好友请求。
 * 
 *         注意如果 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好友请求。 
 * 
 *         求总共会发出多少份好友请求?
 * 
 *          
 * 
 *         示例 1:
 * 
 *         输入: [16,16] 输出: 2 解释: 二人可以互发好友申请。 示例 2:
 * 
 *         输入: [16,17,18] 输出: 2 解释: 好友请求可产生于 17 -> 16, 18 -> 17. 示例 3:
 * 
 *         输入: [20,30,100,110,120] 输出: 3 解释: 好友请求可产生于 110 -> 100, 120 -> 110,
 *         120 -> 100.  
 * 
 *         说明:
 * 
 *         1 <= ages.length <= 20000. 1 <= ages[i] <= 120.
 * 
 */
public class FriendsOfAppropriateAges825A {
	public static int numFriendRequests(int[] ages) {
		int count = 0;
		Arrays.sort(ages);
		int a = ages.length - 1;
		int b = ages.length - 2;
		Map<Integer, Integer> map = new HashMap<>();
		while (a >= 0 && b >= 0) {
			if (map.keySet().contains(ages[a])) {
				map.put(ages[a], map.get(ages[a]) + 1);
			}
			if (ages[a] <= 14) {
				break;
			}
			if (b == 0 && help(ages[a], ages[b])) {
				count += a - b;
				if (a != b && ages[a] == ages[a - 1]) {
					if (!map.containsKey(ages[a])) {
						map.put(ages[a], 0);
					}
					count++;
				}
				a--;
				continue;
			}
			if (a == b) {
				b--;
			} else if (!help(ages[a], ages[b])) {
				count += a - b - 1;
				if (ages[a] == ages[a - 1]) {
					if (!map.containsKey(ages[a])) {
						map.put(ages[a], 0);
					}
					count++;
				}
				a--;
			} else if (b > 0) {
				b--;
			} else {
				count += a - b;
				if (ages[a] == ages[a - 1]) {
					if (!map.containsKey(ages[a])) {
						map.put(ages[a], 0);
					}
					count++;
				}
				a--;
			}
		}
		for (Integer key : map.keySet()) {
			int c = map.get(key);
			if (c > 1) {
				count += c * (c - 1) / 2;
			}
		}
		return count;
	}

	private static boolean help(int a, int b) {
		return !(b > a || b <= (a / 2) + 7 || a <= 14 || b <= 14);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ages = { 98, 60, 24, 89, 84, 51, 61, 96, 108, 87, 68, 29, 14, 11, 13, 50, 13, 104, 57, 8, 57,
				111, 92, 87, 9, 59, 65, 116, 56, 39, 55, 11, 21, 105, 57, 36, 48, 93, 20, 94, 35, 68, 64, 41,
				37, 11, 50, 47, 8, 9 };
		System.out.print(FriendsOfAppropriateAges825A.numFriendRequests(ages));
	}

}
