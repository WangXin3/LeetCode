package com.wxx.code10to19;

/**
 * @author 她爱微笑
 * @date 2020/1/20
 * 输入一个数，将数转为二进制，计算出其中1的个数
 */
public class FindNumCount {

	public int numberOf1(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			// 将flag每次向左移动1位，和n做 & 运算，如果不是0，则说明n这个数，这个位置是1，则count++，
			// 如果是0，则这个位置是0
			if ((n & flag) != 0) {
				count++;
			}
			// flag左移一位
			flag = flag << 1;
		}
		return count;
	}

	public static void main(String[] args) {
		FindNumCount findNumCount = new FindNumCount();
		int i = findNumCount.numberOf1(170);
		System.out.println("i = " + i);
	}
}
