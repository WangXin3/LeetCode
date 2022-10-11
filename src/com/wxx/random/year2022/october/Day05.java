package com.wxx.random.year2022.october;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Xinxin.Wang
 * @since 2022/10/11 17:23
 */
public class Day05 {
    public static void main(String[] args) {
        Solution05 solution05 = new Solution05();
        String[] a = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> list = solution05.subdomainVisits(a);
        list.forEach(System.out::println);
    }
}


class Solution05 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            Integer count = Integer.valueOf(split[0]);
            String domain = split[1];

            String[] domainSplit = domain.split("\\.");
            Set<String> allDomain = getAllDomain(domainSplit);
            for (String a : allDomain) {
                map.merge(a, count, Integer::sum);
            }
        }

        return map.entrySet().stream().map(e -> e.getValue() + " " + e.getKey()).collect(Collectors.toList());
    }

    public Set<String> getAllDomain(String[] domainSplit) {
        Set<String> list = new HashSet<>();
        if (domainSplit.length == 3) {
            list.add(domainSplit[0] + "." + domainSplit[1] + "." + domainSplit[2]);
            list.add(domainSplit[1] + "." + domainSplit[2]);
            list.add(domainSplit[2]);
        }

        if (domainSplit.length == 2) {
            list.add(domainSplit[0] + "." + domainSplit[1]);
            list.add(domainSplit[1]);
        }

        return list;
    }
}