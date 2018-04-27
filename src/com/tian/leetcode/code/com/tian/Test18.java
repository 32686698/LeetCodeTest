package com.tian.leetcode.code.com.tian;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/4sum/description/
 */
public class Test18 {

    public static void main(String[] args) {
        Test18 t = new Test18();
        List list = t.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(list);
    }

    /**
     * 我的实现
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if (len <= 3) return new ArrayList<>();
        Arrays.sort(nums);
        if (4 * nums[0] > target || 4 * nums[len - 1] < target)
            return new ArrayList<>();
        Set<List<Integer>> sets = new HashSet<>();
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int m = j + 1, n = len - 1, he;
                while (m < n) {
                    he = nums[i] + nums[j] + nums[m] + nums[n];
                    if (he > target) {
                        n--;
                    } else if (he == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[m]);
                        list.add(nums[n]);
                        sets.add(list);
                        m++;
                    } else {
                        m++;
                    }
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        lists.addAll(sets);
        return lists;
    }
}
