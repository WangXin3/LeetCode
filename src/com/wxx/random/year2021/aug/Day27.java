package com.wxx.random.year2021.aug;

import java.util.PriorityQueue;

/**
 * @author Xinxin.Wang
 * @since 2021/8/27 9:17
 */
public class Day27 {

    /** initialize your data structure here. */
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public Day27() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }

    public static void main(String[] args) {
        Day27 day27 = new Day27();
        day27.addNum(6);
        System.out.println(day27.findMedian());
        day27.addNum(10);
        System.out.println(day27.findMedian());
        day27.addNum(2);
        System.out.println(day27.findMedian());
//        day27.addNum(6);
//        System.out.println(day27.findMedian());
//        day27.addNum(5);
//        System.out.println(day27.findMedian());
//        day27.addNum(0);
//        System.out.println(day27.findMedian());
//        day27.addNum(6);
//        System.out.println(day27.findMedian());
//        day27.addNum(3);
//        System.out.println(day27.findMedian());
//        day27.addNum(1);
//        System.out.println(day27.findMedian());
//        day27.addNum(0);
//        System.out.println(day27.findMedian());
//        day27.addNum(0);
//        System.out.println(day27.findMedian());
    }
}
