/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 *
 */
public class TopKFrequent347 {
	public static List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			if (!map.containsKey(n)) {
				map.put(n, 1);
			} else {
				map.put(n, map.get(n) + 1);
			}
		}
		List<Map.Entry<Integer, Integer>> entryArrayList = new ArrayList<>(map.entrySet());
		Collections.sort(entryArrayList, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		List<Integer> list = new ArrayList<>();
		int n = 0;
		while (n < k) {
			list.add(entryArrayList.get(n).getKey());
			n++;
		}
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 2, 2, 3 };
		topKFrequent(a, 2);
	}

}
