package com.wxx.code10to19;

/**
 * @author 她爱微笑
 * @date 2020/1/16
 * 机器人运动范围
 * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，
 * 每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 * <p>
 * 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，
 * 它不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
 */
public class RobotMotionRange {
	private final int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private int rows;
	private int cols;
	private int count = 0;
	private int threshold;
	/**
	 * 每个格子索引的数位和
	 */
	private int[][] digitSum;


	public static void main(String[] args) {
		RobotMotionRange robotMotionRange = new RobotMotionRange();
		int i = robotMotionRange.movingCount(9,9,9);
		System.out.println("i = " + i);
	}


	public int movingCount(int threshold, int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.threshold = threshold;
		initDigitSum();
		// 创建一个布尔矩阵，不能进入重复的格子
		boolean[][] marked = new boolean[this.rows][this.cols];
		dfs(marked, 0, 0);

		return count;
	}

	/**
	 * 深度搜索
	 *
	 * @param marked 布尔矩阵
	 * @param row    当前行索引
	 * @param col    当前列索引
	 */
	public void dfs(boolean[][] marked, int row, int col) {
		if (row < 0 || row >= this.rows || col < 0 || col >= this.cols || marked[row][col]) {
			return;
		}

		marked[row][col] = true;
		if (this.digitSum[row][col] > this.threshold) {
			return;
		}

		this.count++;
		for (int[] n : this.next) {
			dfs(marked, row + n[0], col + n[1]);
		}
	}


	/**
	 * 初始化这个矩阵每个点的数位和
	 */
	public void initDigitSum() {
		int[] digitSumOne = new int[Math.max(this.rows, this.cols)];
		// 求这个矩阵中，所有一维点的数位和
		for (int i = 0; i < digitSumOne.length; i++) {
			int n = i;
			while (n > 0) {
				digitSumOne[i] += n % 10;
				n /= 10;
			}

		}

		this.digitSum = new int[this.rows][this.cols];
		// 求矩阵，每个二维点的数位和
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
			}
		}
	}
}
