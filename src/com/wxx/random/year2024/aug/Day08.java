package com.wxx.random.year2024.aug;

import java.util.Arrays;

/**
 * @author wangxin
 * @since 2024/8/8 16:12
 */
public class Day08 {

    public int addedInteger(int[] nums1, int[] nums2) {
        int n2Min = Arrays.stream(nums2).min().getAsInt();
        int n1Min = Arrays.stream(nums1).min().getAsInt();
        return n2Min - n1Min;
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] tempNum1 = Arrays.copyOf(nums1, m);

        int tempM = 0;
        int tempN = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (tempM >= tempNum1.length) {
                nums1[i] = nums2[tempN++];
                continue;
            }
            if (tempN >= nums2.length) {
                nums1[i] = tempNum1[tempM++];
                continue;
            }

            int a = tempNum1[tempM];
            int b = nums2[tempN];
            nums1[i] = Math.min(a, b);

            if (a < b) {
                tempM++;
            } else {
                tempN++;
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (m < 0) {
                nums1[i] = nums2[n--];
                continue;
            }
            if (n < 0) {
                nums1[i] = nums1[m--];
                continue;
            }

            int mm = nums1[m];
            int nn = nums2[n];
            nums1[i] = Math.max(mm, nn);

            if (mm > nn) {
                m--;
            } else {
                n--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 0, 0};
        int[] nums2 = {2, 2, 1, 1};

        Day08 day08 = new Day08();
        System.out.println(day08.addedInteger(nums1, nums2));

        int[] nums3 = {1, 2, 3, 0, 0, 0};
        int[] nums4 = {2, 5, 6};
        day08.merge(nums3, 3, nums4, 3);
        System.out.println(Arrays.toString(nums3));
    }
}
