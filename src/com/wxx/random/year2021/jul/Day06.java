package com.wxx.random.year2021.jul;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Xinxin.Wang
 * @since 2021/7/6 9:31
 */
public class Day06 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Map<String, Integer>> result = new HashMap<>();

        for (List<String> order : orders) {
            // 食物名称
            String foodItem = order.get(2);
            // 餐桌号
            String tableNumber = order.get(1);

            Map<String, Integer> maps = result.getOrDefault(tableNumber, new HashMap<>());
            maps.merge(foodItem, 1, Integer::sum);
            result.put(tableNumber, maps);
        }

        List<String> collect = orders.stream().map(o -> o.get(2)).distinct().sorted().collect(Collectors.toList());

        collect.add(0, "Table");

        List<List<String>> res = new ArrayList<>();


        for (Map.Entry<String, Map<String, Integer>> entry : result.entrySet()) {
            List<String> da = new ArrayList<>();
            da.add(entry.getKey());

            for (int i = 1; i < collect.size(); i++) {
                da.add(entry.getValue().getOrDefault(collect.get(i), 0).toString());
            }
            res.add(da);
        }

        res.sort(Comparator.comparingInt(o -> Integer.parseInt(o.get(0))));

        res.add(0, collect);
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> d = new ArrayList<>();


        // ["Brianna","1","Canadian Waffles"]]
        List<String> l1 = Arrays.asList("James","13","Fried Chicken");
        List<String> l2 = Arrays.asList("Ratesh","12","Fried Chicken");
        List<String> l3 = Arrays.asList("Amadeus","14","Fried Chicken");
        List<String> l4 = Arrays.asList("Adam","1","Canadian Waffles");
        List<String> l5 = Arrays.asList("Brianna","1","Canadian Waffles");

        d.add(l1);
        d.add(l2);
        d.add(l3);
        d.add(l4);
        d.add(l5);

        Day06 day06 = new Day06();
        List<List<String>> lists = day06.displayTable(d);
        for (List<String> list : lists) {
            System.out.println(list.toString());
        }

    }
}
