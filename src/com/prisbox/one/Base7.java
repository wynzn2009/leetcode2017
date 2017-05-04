/**
 * 
 */
package com.prisbox.one;

/**
 * @author admin
 *
 */
public class Base7 {
	public String convertToBase7(int num) {
        StringBuilder b = new StringBuilder();
        if(num==0){
        	return "0";
        }
        int c;
        if(num<0){
        	c = 1;
        	num = -num;
        }else{
        	c = 0;
        }
        while(num>0){
        	b.append(num%7);
        	num /= 7;
        }
        b.reverse();
        return c==1?"-"+b.toString():b.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
