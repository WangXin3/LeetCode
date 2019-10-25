package com.wxx.code10to19;

/**
 * @author 她爱微笑
 * @date 2019/10/25
 * 青蛙跳
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class FrogJump {

	/**
	 * @param n 台阶数
	 * @return
	 */
	public int jumpFloor(int n) {
		/**
		 * 					1				n = 1时
		 * f(n) =			2				n = 2时
		 * 			f(n - 1) + f(n - 2)		n > 1时
		 *
		 */


		if (n <= 2) {
			return n;
		}

		int pre1 = 1, pre2 = 2;
		// 步骤数
		int result = 0;
		for (int i = 2; i < n; i++) {
			result = pre1 + pre2;

			pre1 = pre2;
			pre2 = result;
		}

		return result;
	}

	public static void main(String[] args) {
		FrogJump frogJump = new FrogJump();
		int i = frogJump.jumpFloor(10);
		System.out.println("i = " + i);
	}
}
