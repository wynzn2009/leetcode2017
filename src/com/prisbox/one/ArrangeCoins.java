/**
 * 
 */
package com.prisbox.one;

/**
 * @author admin
 *
 */
public class ArrangeCoins {
	public static int arrangeCoins(int n) {
		return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arrangeCoins(1804289383);
	}

}
