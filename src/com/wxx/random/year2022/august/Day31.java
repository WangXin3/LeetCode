package com.wxx.random.year2022.august;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Xinxin.Wang
 * @since 2022/8/31 9:40
 */
public class Day31 {
    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};

        System.out.println(solution31.validateStackSequences(a, b));
    }
}

class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();

        int pushIndex = 0;
        int popIndex = 0;
        int length = pushed.length - 1;
        while (popIndex <= pushIndex && popIndex <= length) {
            if (deque.isEmpty()) {
                if (pushIndex > length) {
                    break;
                }
                deque.push(pushed[pushIndex]);
                pushIndex++;
            } else {
                Integer peek = deque.peek();
                if (peek == popped[popIndex]) {
                    // 可以弹出
                    deque.pop();
                    popIndex++;
                } else {
                    if (pushIndex > length) {
                        break;
                    }

                    // 不相等 不能弹出 只能继续push
                    deque.push(pushed[pushIndex]);
                    pushIndex++;
                }

            }
        }

        return deque.isEmpty();
    }
}
