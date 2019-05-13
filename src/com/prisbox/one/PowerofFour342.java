/**
 * 
 */
package com.prisbox.one;

/**
 * @author LO 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * 
 *         示例 1:
 * 
 *         输入: 16 输出: true 示例 2:
 * 
 *         输入: 5 输出: false 进阶： 你能不使用循环或者递归来完成本题吗？
 */
public class PowerofFour342 {
	public boolean isPowerOfFour(int num) {
		return num > 0 && ((num & (~0x00000004)) == 0 || (num & (~0x00000040)) == 0
				|| (num & (~0x00000400)) == 0 || (num & (~0x00004000)) == 0 || (num & (~0x00040000)) == 0
				|| (num & (~0x00400000)) == 0 || (num & (~0x04000000)) == 0 || (num & (~0x40000000)) == 0
				|| (num & (~0x00000001)) == 0 || (num & (~0x00000010)) == 0 || (num & (~0x00000100)) == 0
				|| (num & (~0x00001000)) == 0 || (num & (~0x00010000)) == 0 || (num & (~0x00100000)) == 0
				|| (num & (~0x01000000)) == 0 || (num & (~0x10000000)) == 0);
		
		
	}

	public boolean isPowerOfFour1(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
