package com.wxx.code10to19;

/**
 * @author 她爱微笑
 * @date 2020/1/14
 * 输入一个旋转数组，找出该数组最小的元素
 */
public class SpinArrayFindLeastNum {

	public static void main(String[] args) {
		int[] numbers = {4, 5, 6, 7, 1, 2, 3};
//		int[] numbers = {1, 2, 3, 4, 5};
//		int[] numbers = {1, 0, 1, 1, 1};
//		int[] numbers = {1};
//		int[] numbers = null;

		int min = findMin(numbers);
		System.out.println("min = " + min);
	}

	public static int findMin(int[] numbers) {
		// 判断数据合法性
		if (numbers == null || numbers.length <= 0) {
			return -1;
		}

		int index1 = 0;
		int index2 = numbers.length - 1;
		// 最小值索引
		int indexMid = index1;
		// 索引1的元素一定要大于等于索引2的元素
		while (numbers[index1] >= numbers[index2]) {
			// 如果索引2和索引1是相邻的，则最小元素就是索引2所在元素
			if (index2 - index1 == 1) {
				indexMid = index2;
				break;
			}

			// 算出中间索引
			indexMid = (index1 + index2) / 2;
			// 如果索引1、索引2和中间索引所对应的值是一样的，则不能使用二分法查找最小元素
			// 只能通过遍历查找最小元素
			if (numbers[index1] == numbers[index2] && numbers[index2] == numbers[indexMid]) {
				return minIntOrder(numbers, index1, index2);
			}

			// 如果中间索引所在的元素大于等于索引1所在的元素，则说明，中间元素位于索引1所在的递增子数组
			if (numbers[indexMid] >= numbers[index1]) {
				// 将中间索引赋给索引1，这样就减少了一半的工作量，二分法
				index1 = indexMid;
			}

			// 则说明中间元素位于索引2所在的子数组
			if (numbers[indexMid] <= numbers[index2]) {
				index2 = indexMid;
			}
		}


		return numbers[indexMid];
	}

	/**
	 * 通过遍历查询最小元素
	 *
	 * @param numbers
	 * @param index1
	 * @param index2
	 * @return
	 */
	public static int minIntOrder(int[] numbers, int index1, int index2) {

		int result = numbers[index1];

		for (int i = index1 + 1; i <= index2; i++) {
			if (result > numbers[i]) {
				result = numbers[i];
			}
		}
		return result;
	}
}
