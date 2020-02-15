package com.wxx.code10to19;

/**
 * @author 她爱微笑
 * @date 2020/2/15
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，
 * 则打印出 1、2、3 一直到最大的 3 位数即 999。
 */
public class Print1ToMaxOfNDigits17 {

	public static void main(String[] args) {
		Print1ToMaxOfNDigits17 obj = new Print1ToMaxOfNDigits17();
		obj.print1ToMaxOfNDigits(2);
	}

	public void print1ToMaxOfNDigits(int n) {
		if (n <= 0) {
			return;
		}
		char[] number = new char[n];
		print1ToMaxOfNDigits(number, 0);
	}

	private void print1ToMaxOfNDigits(char[] number, int digit) {
		if (digit == number.length) {
			printNumber(number);
			return;
		}
		for (int i = 0; i < 10; i++) {
			// 将int值转为char类型 + '0' 不会改变i值
			number[digit] = (char) (i + '0');
			print1ToMaxOfNDigits(number, digit + 1);
		}
	}

	private void printNumber(char[] number) {
		// 数字索引
		int index = 0;
		// 如果当前位置索引是0，则不打印，++，判断下一个，直到不是0，退出循环
		while (index < number.length && number[index] == '0') {
			index++;
		}

		// 开始打印第一个不是0的位数，打印完不换行，索引自增，打印下一位
		while (index < number.length) {
			System.out.print(number[index++]);
		}
		// 一个数字打印完毕 换行
		System.out.println();

	}
}
