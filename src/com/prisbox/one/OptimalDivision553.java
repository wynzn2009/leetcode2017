/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author 015422404 给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如， [2,3,4] -> 2 / 3 / 4 。
 * 
 *         但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应该含有冗余的括号。
 * 
 *         示例：
 * 
 *         输入: [1000,100,10,2] 输出: "1000/(100/10/2)" 解释: 1000/(100/10/2) =
 *         1000/((100/10)/2) = 200 但是，以下加粗的括号 "1000/((100/10)/2)" 是冗余的，
 *         因为他们并不影响操作的优先级，所以你需要返回 "1000/(100/10/2)"。
 * 
 *         其他用例: 1000/(100/10)/2 = 50 1000/(100/(10/2)) = 50 1000/100/10/2 = 0.5
 *         1000/100/(10/2) = 2 说明:
 * 
 *         输入数组的长度在 [1, 10] 之间。 数组中每个元素的大小都在 [2, 1000] 之间。 每个测试用例只有一个最优除法解。
 * 
 * 
 */
public class OptimalDivision553 {

	public String optimalDivision(int[] nums) {
		if (nums.length == 1) {
			return String.valueOf(nums[0]);
		}
		int length = nums.length;
		int[] p = new int[length - 1];
		for (int i = 0; i < length - 1; i++) {
			p[i] = i + 1;
		}
		double res = 0d;
		int[] rep = null;
		ArrayList<int[]> l = new ArrayList<>();
		init(p, 0, p.length - 1, l);
		for (int[] pp : l) {
			double[] copy = copy(nums);
			double r = div(copy, pp);
			if (r > res) {
				res = r;
				rep = Arrays.copyOf(pp, pp.length);
			}
		}
		String opt = build(nums, rep);
		return opt;
	}

	private String build(int[] nums, int[] rep) {
		LinkedList<Pairs> pairs = new LinkedList<>();
		String[] numstr = new String[nums.length];
		for (int j = 0; j < nums.length; j++) {
			numstr[j] = String.valueOf(nums[j]);
		}
		for (int i = 0; i < rep.length; i++) {
			boolean flag = false;
			if (i != rep.length - 1 && rep[i] > rep[i + 1]) {
				flag = true;
			} else {
				flag = false;
			}
			Pairs p = new Pairs(rep[i] - 1, rep[i] + 1);
			Iterator<Pairs> inter = pairs.iterator();
			while (inter.hasNext()) {
				Pairs s = inter.next();
				if (Pairs.help(s, p)) {
					p = Pairs.mix(s, p);
					inter.remove();
				}
			}
			pairs.add(p);
			if (flag) {
				numstr[p.left] = '(' + numstr[p.left];
				numstr[p.right - 1] = numstr[p.right - 1] + ')';
			}
		}

		return String.join("/", numstr);
	}

	private double div(double[] copy, int[] ind) {
		int index = 0;
		for (int i = 0; i < ind.length; i++) {
			index = ind[i];
			while(copy[index]==0) {
				index++;
			}
			double re = copy[ind[i] - 1] / copy[index];
			copy[ind[i] - 1] = 0;
			copy[index] = re;
		}
		return copy[index];
	}

	private double[] copy(int[] ind) {
		double[] d = new double[ind.length];
		for (int i = 0; i < ind.length; i++) {
			d[i] = ind[i];
		}
		return d;
	}

	private void init(int[] n, int start, int end, ArrayList<int[]> l) {
		if (start == end) {
			l.add(Arrays.copyOf(n, n.length));
		} else {
			for (int i = start; i <= end; i++) {
				swap(n, start, i); // 交换数组第一个元素与后续的元素
				init(n, start + 1, end, l);// 后续元素递归全排列
				swap(n, start, i);// 将交换后的数组还原
			}
		}
	}

	private void swap(int[] n, int start, int end) {
		int temp = n[start];
		n[start] = n[end];
		n[end] = temp;
	}

	public static class Pairs {
		int left;
		int right;

		public Pairs(int left, int right) {
			super();
			this.left = left;
			this.right = right;
		}

		public static boolean help(Pairs a, Pairs b) {
			return (a.left < b.left && a.right < b.right && a.right > b.left)
					|| (b.left < a.left && b.right < a.right && b.right > a.left);
		}

		public static Pairs mix(Pairs a, Pairs b) {
			if (help(a, b)) {
				return new Pairs(Math.min(a.left, b.left), Math.max(a.right, b.right));
			} else {
				throw new RuntimeException();
			}
		}
	}

	public static void main(String[] args) {
		OptimalDivision553 o = new OptimalDivision553();
		int[] nums = { 6, 2, 3, 4, 5 };
		System.out.print(o.optimalDivision(nums));
	}
}
