package com.wxx.random.year2022.august;

/**
 * @author Xinxin.Wang
 * @since 2022/8/10 9:13
 */
public class Day10 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        System.out.println(solution10.solveEquation("-x+5-3+x=6-x-2"));
        System.out.println(solution10.solveEquation("x+5-3+x=6+x-2"));
    }
}

class Solution10 {
    public String solveEquation(String equation) {
        // x变量的系数
        int factor = 0;
        // 常量值
        int val = 0;
        // 字符索引
        int index = 0;
        // 方程字符长度
        int n = equation.length();
        int sign1 = 1; // 等式左边默认系数为正
        while (index < n) {
            // 因为是把右边全部移到左边，过了等号，相当于右边的所有项都乘-1
            if (equation.charAt(index) == '=') {
                sign1 = -1; // 等式右边默认系数为负
                index++;
                continue;
            }

            // 系数
            int sign2 = sign1;
            int number = 0;

            // x有没有常数项系数
            boolean valid = false; // 记录 number 是否有效
            if (equation.charAt(index) == '-' || equation.charAt(index) == '+') { // 去掉前面的符号
                sign2 = (equation.charAt(index) == '-') ? -sign1 : sign1;
                index++;
            }

            // 是数字
            while (index < n && Character.isDigit(equation.charAt(index))) {
                // 构建数字
                number = number * 10 + (equation.charAt(index) - '0');
                index++;
                valid = true;
            }


            if (index < n && equation.charAt(index) == 'x') { // 变量
                factor += valid ? sign2 * number : sign2;
                index++;
            } else { // 数值
                val += sign2 * number;
            }
        }

        if (factor == 0) {
            return val == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + (-val / factor);
    }
}