/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] array = str.toCharArray();
			Arrays.sort(array);
			String key = String.valueOf(array);
			if (map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(key, list);
			}
		}
		List<List<String>> l = new ArrayList<List<String>>(map.values());
		return l;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
