/**
 * 
 */
package com.prisbox.one;

/**
 * @author LO
 *
 */
public class ReplaceElementswithGreatestElementonRightSide1299 {
	public int[] replaceElements(int[] arr) {
		int r = arr[arr.length - 1];
		arr[arr.length - 1] = -1;
		if (arr.length == 1) {
			return arr;
		}

		for (int i = arr.length - 2; i >= 0; i--) {
			int t = arr[i];
			arr[i] = r;
			r = Math.max(r, t);
		}
		return arr;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
