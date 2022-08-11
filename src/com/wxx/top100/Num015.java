package com.wxx.top100;

import java.util.*;

/**
 * @author Xinxin.Wang
 * @since 2022/8/11 13:48
 */
public class Num015 {
    public static void main(String[] args) {
        Solution015 solution015 = new Solution015();
        int[] a = {-4, -1, -1, 0, 1, 2};
        List<List<Integer>> list = solution015.threeSum2(a);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }
}

class Solution015 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return Collections.emptyList();
        }

        Set<List<Integer>> set = new HashSet<>();

        for (int x = 0; x < n; x++) {
            for (int y = x + 1; y < n; y++) {
                for (int z = y + 1; z < n; z++) {

                    if (nums[x] + nums[y] + nums[z] == 0) {
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        arrayList.add(nums[x]);
                        arrayList.add(nums[y]);
                        arrayList.add(nums[z]);
                        arrayList.sort(Integer::compareTo);
                        set.add(arrayList);
                    }

                }
            }
        }


        return new ArrayList<>(set);
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return Collections.emptyList();
        }
        Set<List<Integer>> set = new HashSet<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(nums[i], list);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = -(nums[i] + nums[j]);
                List<Integer> list = map.get(x);
                if (list != null) {
                    for (Integer xxx : list) {
                        if (xxx > j) {
                            List<Integer> ans = new ArrayList<>();
                            ans.add(nums[i]);
                            ans.add(nums[j]);
                            ans.add(nums[xxx]);
                            ans.sort(Integer::compareTo);
                            set.add(ans);
                        }

                    }
                }

            }
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
