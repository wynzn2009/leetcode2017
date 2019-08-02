/**
* 
*/
package com.prisbox.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author LO 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h,
 *         k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * 
 *         注意： 总人数少于1100人。
 * 
 *         示例
 * 
 *         输入: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 *         输出: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionbyHeight406 {
	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o2[0] - o1[0];
				}
			}
		});
		ArrayList<int[]> k = new ArrayList<>();
		for (int i = 0; i < people.length; i++) {
			int[] a = people[i];
			k.add(a[1], a);
		}
		int[][] re = new int[people.length][2];
		return k.toArray(re);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		// TODO Auto-generated method stub
		QueueReconstructionbyHeight406.reconstructQueue(people );
	}

}
