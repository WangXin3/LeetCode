package com.wxx.code10to19;

/**
 * @author 她爱微笑
 * @date 2020/2/13
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方
 */
public class Power16 {

	/**
	 * @param base     底数
	 * @param exponent 指数
	 * @return
	 */
	public static double power(double base, int exponent) {
		if (exponent == 0) {
			// 任何数的0次方是1
			return 1;
		} else if (exponent == 1) {
			// 任何数的1次方是原数
			return base;
		}

		// 如果指数是负数，则先取指数绝对值，算出次方之后，对结果取倒数

		// 先取指数绝对值
		int absExponent = exponent < 0 ? -exponent : exponent;

		// 算出次方之后
		/**
		 * x的n次方可以转换为，这样程序计算时，每次遍历时可以减少 n/2的循环
		 * 			(x * x) ^ n/2		n为偶数
		 * x^n =
		 *			x * (x * x) ^ n/2	n为奇数
		 */
		double power = power(base * base, absExponent / 2);
		// 如果指数为奇数，则需要多乘一次底数
		if (absExponent % 2 == 1) {
			power *= base;
		}

		// 如何指数小于0，对结果取倒数
		if (exponent < 0) {
			power = 1 / power;
		}

		return power;
	}

	public static void main(String[] args) {
		double power = power(2, 1);
		System.out.println("power = " + power);
	}
}
