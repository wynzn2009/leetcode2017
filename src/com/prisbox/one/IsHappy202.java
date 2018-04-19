/**
 * 
 */
package com.prisbox.one;

import java.util.HashSet;

/**
 * @author admin
 *
 */
public class IsHappy202 {
	public static boolean isHappy(int n) {
		if(n==1){
			return true;
		}
		HashSet<Integer> set = new HashSet<>();
		int sum = 0;
		int t = 0;
		while(true){
			while(n>0){
				t = n%10;
				sum += t*t;
				n /= 10;
			}
			if(sum==1||sum==7){
				return true;
			}else if(set.contains(sum)){
				return false;
			}else{
				set.add(sum);
				n = sum;
				sum = 0;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isHappy(2);
	}

}
