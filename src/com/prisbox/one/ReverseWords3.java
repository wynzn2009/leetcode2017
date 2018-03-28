/**
 * 
 */
package com.prisbox.one;

import java.util.LinkedList;

/**
 * @author admin
 *
 */
public class ReverseWords3 {
	public static String reverseWords(String s) {
		if(s==null||s.length()<2){
			return s;
		}
		LinkedList<Character> stack = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<s.length();i++){
			Character c = s.charAt(i);
			if(c.equals(' ')){
				while(!stack.isEmpty()){
					sb.append(stack.pop());
				}
				sb.append(c);
			}else{
				stack.push(c);
			}
		}
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		return sb.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "Let's take LeetCode contest";
		System.out.println(reverseWords(a));
	}

}
