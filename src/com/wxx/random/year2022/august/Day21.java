package com.wxx.random.year2022.august;

/**
 * @author Xinxin.Wang
 * @since 2022/8/22 10:42
 */
public class Day21 {
    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        System.out.println(solution21.isPrefixOfWord("this problem is an easy problem", "pro"));
    }
}

class Solution21 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            // ? 匹配 0 或 1个
            // + 匹配 1 或 多个
            // * 匹配 0 或 多个
            // ^xx   以xx开头
            if (words[i].matches("^" + searchWord + "\\w*")) {
                return i + 1;
            }

//            if (words[i].startsWith(searchWord)) {
//                return i + 1;
//            }
        }

        return -1;
    }
}