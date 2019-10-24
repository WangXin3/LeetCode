package com.wxx.code10to19;

/**
 * @author 她爱微笑
 * @date 2019/10/24
 * 斐波那契数列
 */
public class FibonacciSequence {

	/**
	 * 方式1
	 * @param n
	 * @return
	 */
	public int fibonacci1(int n) {
		if (n <= 1) {
			return n;
		}

		int[] fib = new int[n + 1];

		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}

		return fib[n];
	}

	/**
	 * 方式2
	 * @param n
	 * @return
	 */
	public int fibonacci2(int n) {
		if (n <= 1) {
			return n;
		}
		int pre2 = 0, pre1 = 1;
		int fib = 0;
		for (int i = 2; i <= n; i++) {
			fib = pre2 + pre1;
			pre2 = pre1;
			pre1 = fib;
		}
		return fib;
	}



	public static void main(String[] args) {
		FibonacciSequence fibonacciSequence = new FibonacciSequence();
		long l = System.currentTimeMillis();
//		int fibonacci = fibonacciSequence.fibonacci1(10);
		int fibonacci = fibonacciSequence.fibonacci2(46);

		long l1 = System.currentTimeMillis();
		System.out.println("共耗时" + (l1 - l) + "毫秒");
		System.out.println("fibonacci = " + fibonacci);
	}
}
