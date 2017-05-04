/**
 * 
 */
package com.prisbox.one;

/**
 * @author admin
 *
 */
public class EliminationGame {
	public int lastRemaining(int n) {
		return n == 1 ? 1 : 2 * (1 + n / 2 - lastRemaining(n / 2));
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
