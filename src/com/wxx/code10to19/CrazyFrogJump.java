package com.wxx.code10to19;

/**
 * @author 她爱微笑
 * @date 2020/1/13
 * 变态青蛙跳
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级.
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法.
 */
public class CrazyFrogJump {

	/**
	 * 跳n-1阶台阶, 可以从n-2跳1阶上去, 也可以从n-3跳2阶上去, 那么
	 * f(n-1) = f(n-2) + f(n-3) + ... + f(0)		1
	 *
	 * 同理, 共有n阶台阶, 可以从n-1跳1阶上去, 也可以从n-2跳2阶上去, 那么
	 * f(n) = f(n-1) + f(n-2) + ... +f(0)			2
	 *
	 * 那么 2式 - 1式, 得到f(n) - f(n-1) = f(n-1), 可写为 f(n) = 2 * f(n-1)
	 * 那么该问题就是一个等比数列
	 */


	public static void main(String[] args) {
		int i = jumpFloor(5);
		System.out.println("i = " + i);
	}

	public static int jumpFloor(int target) {
		return (int) Math.pow(2, target - 1);
	}
}
