package com.tian.leetcode.code.com.tian;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/description/
 */
public class Test16 {

    public static void main(String[] args) {
        Test16 t = new Test16();
        int a = 0;
        a = t.threeSumClosest(new int[]{-1, 2, 1, -4}, 2);
        System.out.println(a);
        a = t.threeSumClosest(new int[]{0, 1, 2}, 0);
        System.out.println(a);
        a = t.threeSumClosest(new int[]{1, 1, 1, 1}, 0);
        System.out.println(a);
        a = t.threeSumClosest(new int[]{1, 1, 1, 0}, -100);
        System.out.println(a);
        a = t.threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82);
        System.out.println(a);
    }

    /**
     * 我的实现
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minCha = Integer.MAX_VALUE, res = 0;
        for (int k = 0; k < nums.length; k++) {
            int i = k + 1, j = nums.length - 1, he;
            while (i < j) {
                he = nums[k] + nums[i] + nums[j];
                if (minCha > Math.abs(target - he)) {
                    res = he;
                    minCha = Math.abs(target - he);
                }
                if (target - he > 0) {
                    i++;
                } else if (target - he == 0) {
                    return res;
                } else {
                    j--;
                }
            }
        }
        return res;
    }


    /**
     * 最快的实现
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest2(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int less = nums[0] + nums[1] + nums[2];
        int more = nums[n - 3] + nums[n - 2] + nums[n - 1];
        if (less >= target)
            return less;
        if (more <= target)
            return more;
        for (int i = 0; i < n - 2; i++) {
            int min = nums[i] + nums[i + 1] + nums[i + 2];
            int max = nums[i] + nums[n - 2] + nums[n - 1];
            if (min > target) {
                more = Math.min(more, min);
                break;
            }
            if (max < target) {
                less = Math.max(less, max);
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) return target;
                else if (sum > target) {
                    more = Math.min(more, sum);
                    while (--k > j && nums[k] == nums[k + 1]) ;
                } else {
                    less = Math.max(less, sum);
                    while (++j < k && nums[j] == nums[j - 1]) ;
                }
            }
        }
        return more - target > target - less ? less : more;
    }
}
