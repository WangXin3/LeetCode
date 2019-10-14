package com.wxx.code3to9;

/**
 * 二维数组查找
 * @author 她爱微笑
 * @date 2019/10/14
 */
public class TwoDimensionalLookup {

	public static void main(String[] args) {
		int target = 16;
		int[][] dimensional = {
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};

		boolean b = find(target, dimensional);
		System.out.println("b = " + b);
	}

	public static boolean find(int target, int[][] dimensional) {
		if (dimensional == null || dimensional.length <= 0
				|| dimensional[0].length <= 0) {
			return false;
		}

		int rows = dimensional.length;
		int cols = dimensional[0].length;

		int tempRows = 0;
		int tempCols = cols - 1;

		while (tempRows <= rows - 1 && tempCols >= 0) {
			if (target == dimensional[tempRows][tempCols]) {
				return true;
			} else if (target > dimensional[tempRows][tempCols]) {
				tempRows++;
			} else if (target < dimensional[tempRows][tempCols]) {
				tempCols--;
			}
		}

		return false;
	}

}
