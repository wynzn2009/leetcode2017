/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 *
 */
public class ReadBinaryWatch401 {
	private String[][] hour = { { "0" }, { "1", "2", "4", "8" }, { "3", "5", "6", "9", "10" }, { "7", "11" } };
	private String[][] minus = { { "00" }, { "01", "02", "04", "08", "16", "32" },
			{ "03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48" },
			{ "07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49",
					"50", "52", "56" },
			{ "15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58" },
			{ "31", "47", "55", "59" } };

	public List<String> readBinaryWatch(int num) {
		if (num < 0 || num > 8) {
			return new ArrayList<>();
		}
		int count = 0;
		List<String> result = new ArrayList<>();
		while (count < 4) {
			if (num > 5 || num < 0) {
				count++;
				num--;
				continue;
			}
			for (int i = 0; i < hour[count].length; i++) {
				for (int j = 0; j < minus[num].length; j++) {
					result.add(hour[count][i] + ":" + minus[num][j]);
				}
			}
			count++;
			num--;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadBinaryWatch401 r = new ReadBinaryWatch401();
		r.readBinaryWatch(1);
	}

}
