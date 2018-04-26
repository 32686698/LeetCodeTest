package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 */
public class Test11 {

    public static void main(String[] args) {
        Test11 t = new Test11();
        int[] b = new int[14400];
        int sta = 15000;
        for (int i = 0; i < b.length; i++) {
            b[i] = sta--;
        }
        int a = t.maxArea(b);
        System.out.println(a);
    }

    /**
     * 我的实现  最后 一个用例超时
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height.length <= 1) return 0;
        int hi = 1, res = 0, syg = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] <= syg) {
                continue;
            }
            hi = 0;
            for (int j = i + 1; j < height.length; j++) {
                hi++;
                if (height[j] == 0) continue;
                res = Math.max(res, Math.min(height[i], height[j]) * hi);
            }
            syg = height[i];
        }
        return res;
    }


    /**
     * 优化的实现
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right && left >= 0 && right <= height.length - 1) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
