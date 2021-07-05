package com.wxx.random.jul;

import java.util.*;

/**
 * @author Xinxin.Wang
 * @since 2021/7/5 9:21
 */
public class Day05 {

    int i, n;
    String formula;

    public String countOfAtoms(String formula) {
        this.i = 0;
        this.n = formula.length();
        this.formula = formula;

        Deque<Map<String, Integer>> stack = new LinkedList<>();
        stack.push(new HashMap<>()); // 栈顶哈希表，存放所有原子的个数，在计算过程中不会被pop，只会被peek
        while (i < n) {
            char ch = formula.charAt(i);
            if (ch == '(') { // 遇到前括号就压入一个空哈希表
                i++;
                stack.push(new HashMap<>()); // 将一个空的哈希表压入栈中，准备统计括号内的原子数量
            } else if (ch == ')') { // 遇到后括号就弹出括号内的原子数量，乘以括号后面的数目，存放在栈顶的哈希表中
                i++;
                int num = parseNum(); // 括号右侧数字
                Map<String, Integer> popMap = stack.pop(); // 弹出括号内的原子数量
                Map<String, Integer> topMap = stack.peek();
                for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                    String atom = entry.getKey();
                    int v = entry.getValue();
                    topMap.put(atom, topMap.getOrDefault(atom, 0) + v * num); // 将括号内的原子数量乘上 num，加到上一层的原子数量中
                }
            } else {
                String atom = parseAtom();
                int num = parseNum();
                Map<String, Integer> topMap = stack.peek();
                topMap.put(atom, topMap.getOrDefault(atom, 0) + num); // 统计原子数量
            }
        }

        // 计算完成，弹出栈顶哈希表，开始返回结果
        Map<String, Integer> map = stack.pop();
        // TreeMap是根据key自动排序的，key的对象必须实现Comparator接口，String已经实现了，如果是自定义实体类则需要实现Comparator接口
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String atom = entry.getKey();
            int count = entry.getValue();
            sb.append(atom);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public String parseAtom() {
        StringBuffer sb = new StringBuffer();
        sb.append(formula.charAt(i++)); // 扫描首字母
        while (i < n && Character.isLowerCase(formula.charAt(i))) {
            sb.append(formula.charAt(i++)); // 扫描首字母后的小写字母
        }
        return sb.toString();
    }

    public int parseNum() {
        if (i == n || !Character.isDigit(formula.charAt(i))) {
            return 1; // 不是数字，视作 1
        }
        int num = 0;
        while (i < n && Character.isDigit(formula.charAt(i))) {
            num = num * 10 + formula.charAt(i++) - '0'; // 扫描数字 字符0-9的十进制范围是48 - 57
            // 这里- '0' 是因为formula.charAt(i++)取出的是一个char，如果不减去字符0，结果将错误
            // 例子 102 System.out.println(10 * 10 + '2' - '0');  150 System.out.println(10 * 10 + '2');
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(10 * 10 + '2' - '0');
    }

}
