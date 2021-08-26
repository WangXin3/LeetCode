package com.wxx.random.aug;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2021/8/26 9:18
 */
public class Day26 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0, right = people.length - 1;

        int count = 0;
        while (left <= right) {
            if (people[left] + people[right] > limit) {
                count++;
                right--;
            } else {
                count++;
                left++;
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Day26 day26 = new Day26();
        int[] people = {3,5,3,4,2,2,1,1};


        System.out.println(day26.numRescueBoats(people, 5));
    }
}
