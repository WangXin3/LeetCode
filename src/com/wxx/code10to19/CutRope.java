package com.wxx.code10to19;

/**
 * @author 她爱微笑
 * @date 2020/1/19
 * 剪绳子
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大，怎么剪使得乘积最大，是多少？
 */
public class CutRope {

	/**
	 * 获取最大的乘积
	 * 动态规划
	 *
	 * @param length 绳子的长度
	 * @return 最大乘积
	 */
	public int maxValue1(int length) {
		// 当长度为1时，不能剪
		if (length <= 1) {
			return 0;
		} else if (length == 2) {
			// 当长度为2时，只能剪1刀
			return 1;
		} else if (length == 3) {
			// 当长度为3时，有两种剪法，1，1，1和1，2，但1，2为最符合题意的解
			return 2;
		}
		// 创建一个存储子问题解的数组
		int[] products = new int[length + 1];
		// 下面这四个不是对应长度时的最优解，只是一个定值，在大于3长度时使用，
		// 因为任何数只有乘以这四个数本身，所得乘积才是最大。分解的话只会让这个乘积更小。
		// 如 3 * 2 乘积为6， 分解3 为 1， 2。  (1 * 2) * 2 = 4 所以不是最优解
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;

		// 临时变量
		int max = 0;
		// 先将这个问题划分为子问题，从下往上求解
		for (int i = 4; i <= length; i++) {
			// 赋默认值
			max = 0;
			// 求出切出第一刀之后的子问题解  i / 2的原因是：要用两个分解的数做乘积，所以只需遍历一半就可以用 ‘和’ 减去 当前值，
			// 求可以知道另一半，没必要遍历，如 i = 5 ，只需遍历到 2，则可以知道 1，4乘积， 2，3乘积， 没必要求3，2的乘积。
			for (int j = 1; j <= i / 2; j++) {
				// 求出当前子问题的最大乘积
				int product = products[j] * products[i - j];
				// 将最大值赋给max
				max = Math.max(product, max);
				products[i] = max;
			}
		}
		max = products[length];
		return max;
	}

	/**
	 * 贪婪算法
	 * n >= 5时		3(n - 3) > n
	 * 				2(n - 2) > n
	 * n >= 5时		3(n - 3) >= 2(n - 2)
	 * @param length
	 * @return
	 */
	public int maxValue2(int length) {
		if (length <= 1) {
			return 0;
		} else if (length == 2) {
			return 1;
		} else if (length == 3) {
			return 2;
		}

		// 尽可能多的剪去长度为3的绳子段
		int timesOf3 = length / 3;
		// 如果正好剩长度为4的绳子段，则不能剪去3的绳子段
		// 此时更好的办法是，把绳子切为长度为2的两段，因为 1 * 3 < 2 * 2
		if (length - timesOf3 * 3 == 1) {
			timesOf3 -= 1;
		}
		// 可以切多少个长度为2的绳子段
		int timesOf2 = (length - timesOf3 * 3) / 2;

		// 算出乘积
		return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
	}

	public static void main(String[] args) {
		CutRope cutRope = new CutRope();
		int i = cutRope.maxValue1(8);
		int i2 = cutRope.maxValue2(8);
		System.out.println("i = " + i);
		System.out.println("i2 = " + i2);
	}
}
