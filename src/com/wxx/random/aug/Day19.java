package com.wxx.random.aug;

/**
 * @author Xinxin.Wang
 * @since 2021/8/19 9:21
 */
public class Day19 {

    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int i = 0, j = charArray.length - 1;
        while (i < j) {

            if (isVowel(charArray[i]) && isVowel(charArray[j])) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++;
                j--;
                continue;
            }

            if (isVowel(charArray[i])) {
                j--;
            } else {
                i++;
            }
        }

        return new String(charArray);
    }

    public boolean isVowel(char a) {
        return (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U' || a == 'u');
    }

    public static void main(String[] args) {
        Day19 day19 = new Day19();
        System.out.println(day19.reverseVowels("lEetcOde"));
    }
}
