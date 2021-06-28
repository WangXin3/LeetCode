package com.wxx.random.jun;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个二进制字符串 s 和一个整数 k 。
 * 如果所有长度为 k 的二进制字符串都是 s 的子串，请返回 true ，否则请返回 false 。
 * <p>
 * 长度为 k 的二进制串的数量为 2^k 如k等于1，则有 0， 1
 * 如k等于2 则有00 01 10 11
 * <p>
 * 2 ^ k 可以写成 1 << k
 *
 * <p>
 * value << num 左移运算，将value转换为二进制，向左边移动，左边有0则删，右边补0，每次左移一次，就相当与乘2
 * value >> num 右移运算，每右移一次，则相当于除2，余数忽略
 *
 * @author Xinxin.Wang
 * @since 2021/6/28 10:35
 */
public class Day28 {

    public boolean hasAllCodes1(String s, int k) {
        // 前提是 s分割成 k位字符子串 并存储到hash表，如果满足条件则hash表长度等于 2^k

        // 如果 s 包含 2^k 个长度为 k 的二进制串，那么它的长度至少为 2^k + k - 1
        if (s.length() < (1 << 2) + k - 1) {
            return false;
        }

        Set<String> exists = new HashSet<>();
        for (int i = 0; i + k <= s.length(); i++) {
            exists.add(s.substring(i, i + k));
        }

        // hash表自动去重，长度为 k 的二进制串的数量为 2^k
        // 所以通过exists的长度就可以判断出s中有没有所有的k
        return exists.size() == (1 << k);
    }

    public static void main(String[] args) {
        Day28 day28 = new Day28();
        System.out.println(day28.hasAllCodes1("00110110", 2));
    }
}
