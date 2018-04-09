/**
 * 
 */
package com.prisbox.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 *
 */
public class GetHint299 {
	public String getHint(String secret, String guess) {
		int a = 0;
		int b = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < secret.length(); i++) {
			if (map.containsKey(secret.charAt(i))) {
				map.put(secret.charAt(i), map.get(secret.charAt(i)) + 1);
			} else {
				map.put(secret.charAt(i), 1);
			}
		}
		String re = "";
		for (int j = 0; j < guess.length(); j++) {
			if (guess.charAt(j) == secret.charAt(j)) {
				a++;
				if (map.get(secret.charAt(j)) > 1) {
					map.put(secret.charAt(j), map.get(secret.charAt(j)) - 1);
				} else {
					map.remove(secret.charAt(j));
				}
			} else {
				re += guess.charAt(j);
			}
		}
		for (int l = 0; l < re.length(); l++) {
			if (map.containsKey(re.charAt(l))) {
				b++;
				if (map.get(re.charAt(l)) > 1) {
					map.put(re.charAt(l), map.get(re.charAt(l)) - 1);
				} else {
					map.remove(re.charAt(l));
				}
			}
		}
		return a + "A" + b + "B";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetHint299 g = new GetHint299();
		g.getHint("1807", "7810");
	}

}
