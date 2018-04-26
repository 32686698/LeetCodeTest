package com.tian.leetcode.code.com.tian;

import java.util.*;

public class Test15 {

    public static void main(String[] args) {
        Test15 t = new Test15();
        List<List<Integer>> l = t.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> ls : l) {
            for (Integer i : ls) {
                System.out.print(i + " ,");
            }
            System.out.println();
        }
    }
    /**
     * 我的实现  超过时间限制
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        List<List<Integer>> ress = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] + nums[j];
                List<List<Integer>> list = map.get(key);
                if (null == list) {
                    list = new ArrayList<>();
                }
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(j);
                list.add(l);
                map.put(key, list);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int cha = nums[i] * -1;
            List<List<Integer>> list = map.get(cha);
            if (null == list) continue;
            for (List<Integer> l : list) {
                if (!l.contains(i)) {
                    List<Integer> ll = new ArrayList<>();
                    ll.add(nums[i]);
                    ll.add(nums[l.get(0)]);
                    ll.add(nums[l.get(1)]);

                    ress.add(ll);
                }
            }
        }
        Set<List<Integer>> set = new HashSet<>();
        for (List<Integer> l : ress) {
            l.sort(new Comparator<Integer>() {
                public int compare(Integer n1, Integer n2) {
                    return n1.compareTo(n2);
                }
            });
            set.add(l);
        }
        ress = new ArrayList<>();
        ress.addAll(set);
        return ress;
    }

}
