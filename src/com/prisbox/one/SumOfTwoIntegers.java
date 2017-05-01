/**
 * 
 */
package com.prisbox.one;

/**
 * @author LO
 *
 */
public class SumOfTwoIntegers {
	public int getSum(int a, int b) {
		int temp = 0;
		int result = 0;
		int n = 32;
		int index = 1;
		while(n-->0){
			int aa = a&1;
			a >>>= 1;
			int bb = b&1;
			b >>>= 1;
			int count = 0;
			if(aa>0){
				count++;
			}
			if(bb>0){
				count++;
			}
			if(temp>0){
				count++;
			}
			if(count%2>0){
				result |= index;
			}
			if(count>1){
				temp = 1;
			}else{
				temp = 0;
			}
			index <<= 1;
		}
		return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumOfTwoIntegers s = new SumOfTwoIntegers();
		int t = 5;
		int l = 7;
		int r = s.getSum(t, l);
		System.out.println(r);
		assert r == t+l;
	}

}
