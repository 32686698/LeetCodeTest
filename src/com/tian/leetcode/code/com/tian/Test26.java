package com.tian.leetcode.code.com.tian;

import com.tian.shujujiegou.code1.Util;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class Test26 {

    public static void main(String[] args) {
        Test26 t = new Test26();
        int[] a = new int[]{1,1,1,2,2,3,4,4,5,6,6,7,7};
        int tt = t.removeDuplicates2(a);
        System.out.println(tt);
        Util.printlnArray(a);
    }

    /**
     * 我的实现
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }

        int leng = nums.length;
        for (int i = 1; i < leng; i++) {
            if(nums[i]==nums[i-1]){
                for (int j = i;j < leng -1 ; j ++){
                    nums[j] = nums[j+1];
                }
                leng --;
                i--;
            }
        }
        return leng;
    }

    /**
     * 原地算法
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[count++] = nums[i];
            }
        }

        return count;
    }
}
