/**
 * @author 她爱微笑
 * @date 2019/9/29
 * Looking for repetitions
 * 寻找重复数
 */
public class LookingForRepetitions {

	public static void main(String[] args) {
		int[] data = {2, 3, 1, 0, 2, 5};
		int[] data1 = new int[1];
//		boolean duplicate = duplicate(data, data.length, data1);
//		System.out.println("duplicate = " + data1[0]);

		int i = duplicate1(data);
		System.out.println("i = " + i);
	}


	public static int findDuplicate(int[] nums) {
		// 找到两个跑步者的交点
		int tortoise = nums[0];
		int hare = nums[0];
		do {
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		} while (tortoise != hare);

		// 找到循环的入口
		int ptr1 = nums[0];
		int ptr2 = tortoise;
		while (ptr1 != ptr2) {
			ptr1 = nums[ptr1];
			ptr2 = nums[ptr2];
		}

		return ptr1;
	}

	public static int findDuplicate1(int[] nums) {
		if (nums == null || nums.length < 2) {
			return -1;
		}

		int[] hashTable = new int[nums.length];
		for (int item : nums) {
			if (hashTable[item] >= 1) {
				return item;
			} else {
				hashTable[item] = 1;
			}
		}

		return -1;
	}

	public static int findDuplicate2(int[] nums) {
		if (nums == null || nums.length < 2) {
			return -1;
		}

		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				} else {
					int temp = nums[i];
					nums[i] = nums[temp];
					nums[temp] = temp;
				}
			}
		}

		return -1;
	}

	public static int findDuplicate3(int[] data) {
		if (data == null || data.length < 2) {
			return -1;
		}

		//数组值在[start,end]间
		int start = 1;
		int end = data.length - 1;
		while (start <= end) {
			int middle = (end - start) / 2 + start;
			int count = countRange(data, start, middle);
			if (start == end) {
				if (count > 1) {
					return start;
				} else {
					break;
				}
			}
			if (count > middle - start + 1) {
				end = middle;
			} else {
				start = middle + 1;
			}
		}
		return -1;
	}

	public static int countRange(int[] data, int start, int end) {
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			if (start <= data[i] && end >= data[i]) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 1. 先看下标i是否等于下标i对应的值j
	 * 2. 如果等于 i++ 执行1 如果不等于执行3
	 * 3. 判断值j是否等于用j为下标的值jj
	 * 4. 如果等于返回重复值j 如果不等于执行j值和jj值互换位置 继续执行3
	 * @param nums
	 * @param length
	 * @param duplication
	 * @return
	 */
	public static boolean duplicate(int[] nums, int length, int[] duplication) {
		if (nums == null || length <= 0) {
			return false;
		}
		for (int i = 0; i < length; i++) {
			while (nums[i] != i) {
				if (nums[i] == nums[nums[i]]) {
					duplication[0] = nums[i];
					return true;
				}
				swap(nums, i, nums[i]);
			}
		}
		return false;
	}

	private static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}


	public static int duplicate1(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return -1;
		}

		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				} else {
					int temp = nums[i];
					nums[i] = nums[temp];
					nums[temp] = temp;
				}
			}
		}
		return -1;
	}
}
