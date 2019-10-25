package com.wxx.code10to19;

/**
 * @author 她爱微笑
 * @date 2019/10/25
 * 矩形覆盖
 */
public class RectangularCover {

	/**
	 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
	 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
	 */

	/**
	 *
	 * @param n 2 * n 的矩形
	 * @return
	 */
	public int rectCover(int n) {
		if (n <= 2){
			return n;
		}

		int pre1 = 1, pre2 = 2, result = 0;

		for (int i = 2; i < n; i++) {
			result = pre1 + pre2;

			pre1 = pre2;
			pre2 = result;
		}

		return result;
	}

	public static void main(String[] args) {
		RectangularCover rectangularCover = new RectangularCover();
		int i = rectangularCover.rectCover(5);
		System.out.println("i = " + i);

	}

}
