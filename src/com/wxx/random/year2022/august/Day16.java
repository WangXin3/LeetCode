package com.wxx.random.year2022.august;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2022/8/16 9:16
 */
public class Day16 {
    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);
        System.out.println(orderedStream.insert(3, "ccccc"));
        System.out.println(orderedStream.insert(1, "aaaaa"));
        System.out.println(orderedStream.insert(2, "bbbbb"));
        System.out.println(orderedStream.insert(5, "eeeee"));
        System.out.println(orderedStream.insert(4, "ddddd"));
    }
}

class OrderedStream {
    String[] stream;
    int ptr = 0;

    public OrderedStream(int n) {
        this.stream = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        idKey -= 1;
        List<String> ans = new ArrayList<>();
        stream[idKey] = value;
        if (ptr == idKey) {
            while (ptr < stream.length && stream[ptr] != null) {
                ans.add(stream[ptr]);
                ptr++;
            }
        } else {
            return ans;
        }

        return ans;
    }
}
