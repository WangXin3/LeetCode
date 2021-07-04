package com.wxx.random.jul;

import java.util.*;

/**
 * @author wangxin
 * @since 2021/7/3
 */
public class Day03 {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>(16);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.merge(c, 1, Integer::sum);
        }

        Map<Integer, Set<Character>> setMap = new HashMap<>(16);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Set<Character> characters = setMap.get(entry.getValue());
            if (characters == null) {
                Set<Character> set = new HashSet<>();
                set.add(entry.getKey());
                setMap.put(entry.getValue(), set);
            } else {
                characters.add(entry.getKey());
            }
        }

        int[] ints = setMap.keySet().stream().mapToInt(integer -> integer).toArray();
        Arrays.sort(ints);

        StringBuilder sb = new StringBuilder();
        for (int anInt : ints) {
            for (Map.Entry<Integer, Set<Character>> entry : setMap.entrySet()) {
                if (entry.getKey().equals(anInt)) {
                    for (Character character : entry.getValue()) {
                        for (int i = 0; i < anInt; i++) {
                            sb.append(character);
                        }
                    }
                    break;
                }
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        final Day03 day03 = new Day03();
        System.out.println(day03.frequencySort("Aabb"));
    }
}
