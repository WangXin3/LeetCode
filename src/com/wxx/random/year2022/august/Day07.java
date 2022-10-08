package com.wxx.random.year2022.august;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author wangxin
 * @since 2022/8/7
 */
public class Day07 {

    public static void main(String[] args) {
        Solution07 solution07 = new Solution07();
        int[] ints = solution07.exclusiveTime(1, Arrays.asList("0:start:0","0:end:0"));
        // test git
        // test git 2
        // test git 3
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

class Solution07 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        int currentTime = 0;
        for (String s : logs) {
            String[] split = s.split(":");
            int functionId = Integer.parseInt(split[0]);
            boolean isStart = split[1].equals("start");
            int timestamp = Integer.parseInt(split[2]);

            if (deque.isEmpty()) {
                deque.push(functionId);
            } else {
                Integer peek = deque.peek();
                if (peek == functionId) {
                    if (isStart) {
                        // 如果是同一个函数，是递归
                        deque.push(functionId);
                        ans[functionId] += (timestamp - currentTime - 1);
                    } else {
                        // 如果是同一个函数，并且是结束
                        deque.poll();
                        // 函数弹栈 计算耗时 存入ans
                        ans[functionId] += (timestamp - currentTime + 1);
                    }
                } else {
                    // 不是同一个函数
                    if (isStart) {
                        // 是开始，则压栈递归
                        deque.push(functionId);
                        ans[peek] += (timestamp - currentTime - 1);
                    } else {
                        System.out.println("不可能的事，如果发生就是死锁！哈哈");
                    }
                }

            }
            currentTime = timestamp;
        }
        return ans;
    }
}
