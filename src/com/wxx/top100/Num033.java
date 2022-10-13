package com.wxx.top100;

/**
 * @author Xinxin.Wang
 * @since 2022/8/18 16:18
 */
public class Num033 {
    public static void main(String[] args) {
        // 43,54,65,72,0,2,4,6,7,11,23,34

        // [4,5,6,7,8,1,2,3]
        //8
        //0

        //

        Solution033 solution033 = new Solution033();

        int[] a = {43, 54, 65, 20};

        System.out.println(solution033.search(a, 0));
    }
}

class Solution033 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            //
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
