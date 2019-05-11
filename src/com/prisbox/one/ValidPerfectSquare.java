/**
 * 
 */
package com.prisbox.one;

/**
 * @author LO
 *
 */
public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
        int last = num%10;
        if(last==2||last==3||last==7||last==8){
        	return false;
        }
        int min = 0;
        int max = 46341;
        int mid;
        while(min!=max-1&&min!=max){
        	mid = (min+max)/2;
        	int temp = mid*mid;
        	if(num==temp){
        		return true;
        	}else if(num<temp){
        		max = mid;
        	}else{
        		min = mid;
        	}
        }
        return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidPerfectSquare v = new ValidPerfectSquare();
		v.isPerfectSquare(2147395600);
	}

}
