package com.wxx.random.year2024.april;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangxin
 * @since 2024/4/29 16:51
 */
public class Day26 {
    private int snap_cnt;
    private List<int[]>[] data;

    public Day26(int length) {
        snap_cnt = 0;
        data = new List[length];
        for (int i = 0; i < length; i++) {
            data[i] = new ArrayList<>();
        }
    }

    public void set(int index, int val) {
        data[index].add(new int[]{snap_cnt, val});
    }

    public int snap() {
        return snap_cnt++;
    }

    public int get(int index, int snap_id) {
        int x = binarySearch(index, snap_id);
        return x == 0 ? 0 : data[index].get(x - 1)[1];
    }

    private int binarySearch(int index, int snap_id) {
        int low = 0, high = data[index].size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            int[] pair = data[index].get(mid);
            if (pair[0] > snap_id + 1 || (pair[0] == snap_id + 1 && pair[1] >= 0)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


    public static void main(String[] args) {
//        Day26 day26 = new Day26(4);
//        day26.set(0, 5);
//        day26.snap();
//        day26.set(0, 6);
//        System.out.println(day26.get(0, 0));


//        Day26 day26 = new Day26(4);
//        day26.snap();
//        day26.snap();
//        System.out.println(day26.get(3, 1));
//        day26.set(2, 4);
//        day26.snap();
//        day26.set(1, 4);

        Day26 day26 = new Day26(4);
        day26.set(1, 6);
        day26.snap();
        day26.snap();
        day26.set(1, 19);
        day26.set(0, 4);
        System.out.println(day26.get(2, 1));
        System.out.println(day26.get(2, 0));
        System.out.println(day26.get(0, 1));


    }
}
