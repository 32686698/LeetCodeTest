package com.tian.leetcode.code.com.tian;

import com.tian.shujujiegou.code1.Util;

/**
 * https://leetcode.com/problems/remove-element/description/
 */
public class Test27 {

    public static void main(String[] args) {
        Test27 t = new Test27();
        int[] a = new int[]{1,1,1,2,2,3,4,4,5,6,6,7,7};
        int tt = t.removeElement(a,2);
        System.out.println(tt);
        Util.printlnArray(a);
    }

    /**
     * 我的实现
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
