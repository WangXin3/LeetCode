package com.wxx.random.year2022.october;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2022/10/12 13:30
 */
public class Day01 {
    public static void main(String[] args) {
        Solution01 solution01 = new Solution01();
        System.out.println(solution01.reformatNumber("123 4-567"));
    }
}

class Solution01 {
    public String reformatNumber(String number) {
        number = number.replaceAll("[\\s-]", "");
        int length = number.length();

        char[] chars = number.toCharArray();

        // 2 个数字：单个含 2 个数字的块。 mob = 2
        // 3 个数字：单个含 3 个数字的块。 mob = 0
        // 4 个数字：两个分别含 2 个数字的块。 mob = 1
        List<String> list = new ArrayList<>();
        int div = length / 3;
        int mob = length % 3;

        if (mob == 1) {
            div -= 1;
        }

        for (int i = 0; i < div; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i * 3; j < i * 3 + 3; j++) {
                sb.append(chars[j]);
            }
            list.add(sb.toString());
        }

        if (mob == 1) {
            list.add(number.substring(number.length() - 4, number.length() - 2));
            list.add(number.substring(number.length() - 2));
        } else if (mob == 2){
            list.add(number.substring(number.length() - 2));
        }


        return String.join("-", list);
    }
}
