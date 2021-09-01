package com.wxx.random.sep;

/**
 * @author Xinxin.Wang
 * @since 2021/9/1 9:20
 */
public class Day01 {

    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int min = Integer.min(split1.length, split2.length);
        for (int i = 0; i < min; i++) {
            String s1 = split1[i];
            String s2 = split2[i];

            int int1 = Integer.parseInt(s1);
            int int2 = Integer.parseInt(s2);

            if (int1 > int2) {
                return 1;
            } else if (int1 < int2) {
                return -1;
            }
        }

        if (split1.length > min) {
            for (int i = min; i < split1.length; i++) {
                String s = split1[i];
                int i1 = Integer.parseInt(s);
                if (i1 > 0) {
                    return 1;
                }
            }
        }

        if (split2.length > min) {
            for (int i = min; i < split2.length; i++) {
                String s = split2[i];
                int i1 = Integer.parseInt(s);
                if (i1 > 0) {
                    return -1;
                }
            }
        }


        return 0;
    }

    public static void main(String[] args) {
        Day01 day01 = new Day01();
        System.out.println(day01.compareVersion("7.5.2.4", "7.5.3"));


    }
}
