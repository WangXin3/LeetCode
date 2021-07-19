package com.wxx.start;

/**
 * @author Xinxin.Wang
 * @since 2021/7/19 14:52
 */
public class Day03Two {

    public int[] twoSum1(int[] numbers, int target) {
        int[] ans = new int[2];

        int left = 0;
        for (; left < numbers.length; left++) {
            int findValue = target - numbers[left];
            // left + 1的原因是二分查找不能查找到起始位，也就是left，left下标位的元素不能重复使用
            int i = find(numbers, left + 1, numbers.length - 1, findValue);
            if (i != -1) {
                ans[1] = i + 1;
                break;
            }
        }

        ans[0] = left + 1;
        return ans;
    }

    private int find(int[] nums, int left, int right, int findValue) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > findValue) {
                right = mid - 1;
            } else if (nums[mid] < findValue) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) { // 和小于目标值，左指针右移
                ++low;
            } else { // 和大于目标值，右指针左移
                --high;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Day03Two day03Two = new Day03Two();
        int[] nums = {1,2,3,7,11,15,16,17};

        int[] ints = day03Two.twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.print(anInt + ", ");
        }

    }
}
