/**
 * 
 */
package com.prisbox.one;

import java.util.LinkedList;

/**
 * @author LO
 *
 */
public class SimplifyPath71 {
	public static String simplifyPath(String path) {
		String[] st = path.split("/+");
		LinkedList<String> l = new LinkedList<>();
		for (String s : st) {
			if (s.equals("..")) {
				if(!l.isEmpty()) {
					l.pop();
				}
			} else if (s.equals(".") || s.equals("")) {
				continue;
			} else {
				l.push(s);
			}
		}
		StringBuffer sb = new StringBuffer();
		sb.append("/");
		while (!l.isEmpty()) {
			sb.append(l.pollLast()).append("/");
		}
		if (sb.length() > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(SimplifyPath71.simplifyPath("/a//b////c/d//././/../"));
	}
}
