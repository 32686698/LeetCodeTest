package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode.com/problems/sqrtx/description/
 */
public class Test69 {

    public static void main(String[] args) {
        Test69 t = new Test69();
        int tt = t.mySqrt(2147483647);
        System.out.println(tt);
    }

    /**
     * 我的实现
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        for (int i = 1; i <= Integer.MAX_VALUE / 2; i++) {
            long count = (long) i * (long) i;
            if (count == x) {
                return i;
            } else if (count > x) {
                return i - 1;
            }
        }
        return 0;
    }

    /**
     * 牛逼的实现
     * 牛顿迭代法
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1, right = Integer.MAX_VALUE;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid > x / mid) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }


}
