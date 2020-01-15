package com.wxx.code10to19;

/**
 * @author 她爱微笑
 * @date 2020/1/15
 * 矩阵中的路径
 */
public class PathsInMatrix {

	public static void main(String[] args) {
		String arrayStr = "ABCESFCSADEE";
		char[] array = arrayStr.toCharArray();
		int rows = 3;
		int cols = 4;
		String strStr = "BS";
		char[] str = strStr.toCharArray();

		boolean b = hasPath(array, rows, cols, str);
		System.out.println("b = " + b);
	}


	private final static int[][] next = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

	public static boolean hasPath(char[] array, int rows, int cols, char[] str) {
		if (rows == 0 || cols == 0) {
			return false;
		}

		// 创建一个布尔矩阵，用来标识该格子是否被使用, true为被占用，不能再次使用，false为可以使用，默认为false
		boolean[][] marked = new boolean[rows][cols];
		// 构建矩阵
		char[][] matrix = buildMatrix(array, rows, cols);

		// 从此处找需要寻找的字符数组的路径入口，如果寻找中上下左右都不满足，则会重新找入口
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (backtracking(matrix, str, marked, 0, i, j, rows, cols)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * 寻找路径
	 *
	 * @param matrix  矩阵
	 * @param str     需要寻找路径的字符
	 * @param marked  布尔矩阵
	 * @param pathLen 当前寻找的字符索引
	 * @param r       本次寻找所在矩阵的行的索引
	 * @param c       本次寻找所在矩阵的列的索引
	 * @param rows    矩阵总行数
	 * @param cols    矩阵总列数
	 * @return 是否找到 true-找到 false-未找到
	 */
	private static boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int r, int c, int rows, int cols) {

		if (str.length == pathLen) {
			// 找完了
			return true;
		}

		// r < 0 本次寻找所在矩阵的行的索引小于0
		// r >= rows 索引大于等于总行数，数组越界
		// c < 0
		// c >= cols 数组越界
		// matrix[r][c] != str[pathLen] 当前格子和需要查找的字符不一致
		// marked[r][c]  为true，该格子已经被使用
		if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLen] || marked[r][c]) {
			return false;
		}

		// 先将该格子置为已用
		marked[r][c] = true;
		// 循环遍历上下左右四个格子，看是否等于下一个需要查询的字符
		for (int[] n : next) {
			if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1], rows, cols)) {
				return true;
			}
		}
		marked[r][c] = false;
		return false;
	}


	/**
	 * 通过字符数组构建矩阵（二维数组）
	 *
	 * @param array
	 * @return
	 */
	private static char[][] buildMatrix(char[] array, int rows, int cols) {
		int k = 0;
		char[][] data = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				data[i][j] = array[k++];
			}
		}

		return data;
	}
}
