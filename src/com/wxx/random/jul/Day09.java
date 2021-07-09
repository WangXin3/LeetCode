package com.wxx.random.jul;

/**
 * @author Xinxin.Wang
 * @since 2021/7/9 9:23
 */
public class Day09 {

    public int majorityElement(int[] nums) {
        int count = 0, candidate = 0;

        // 为满足题意，candidate作为候选主要元素，与下一个元素坐比较，如果相等count++，不相等则count--，
        // count==0则使用下一个元素作为候选主要元素，如果要作为主要元素，就必须在数组中出现更多次数，这样两个不相等的相互抵消，
        // 总有一个会存在candidate中，candidate中要么是主要元素，要么就是任意一个元素
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // 所以做一个二次遍历，确定candidate是不是主要元素
        int sum = 0;
        for (int num : nums) {
            if (candidate == num) {
                sum++;
            }
        }

        return sum > (nums.length / 2) ? candidate : -1;
    }

    public static void main(String[] args) {
        Day09 day09 = new Day09();
        int[] a = {1, 2, 1, 2, 1, 2, 1, 2, 1};
        System.out.println(day09.majorityElement(a));
    }
}
