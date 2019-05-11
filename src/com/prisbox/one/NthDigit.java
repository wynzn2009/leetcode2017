/**
 * 
 */
package com.prisbox.one;

/**
 * @author admin
 *
 */
public class NthDigit {
	public int findNthDigit(int n) {
        if(n<=9){
        	return n;
        }else{
        	n = n - 9;
        }
        long index = 2L;
        long count = 9L;
        long num = 10L;
        long total;
        while(true){
        	count *= 10;
        	total = count * index;
        	if(n>total){
        		n -= total;
        		index++;
        		num *=10;
        	}else{
        		int t = (int) ((n-1)%index);
        		int x = (int) (num+(n-1)/index);
        		String s = String.valueOf(x);
        		if(t>=s.length()){
        			return 0;
        		}else{
        			
        			return Character.getNumericValue(s.charAt(t));
        		}
        	}
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NthDigit n = new NthDigit();
		int t = n.findNthDigit(1000);
		System.out.println(t);
	}

}
