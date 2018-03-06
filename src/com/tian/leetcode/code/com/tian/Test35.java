package com.tian.leetcode.code.com.tian;

/**
 * https://leetcode.com/problems/search-insert-position/description/
 */
public class Test35 {

    public static  void main(String[] args){
        Test35 t = new Test35();
        int[] a = new int[]{1,3,5,6};
        int tt = t.searchInsert(a,0);
        System.out.println(tt);
    }

    /**
     * 我的实现
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if(nums==null){
            return -1;
        }
        if(nums.length==0){
            return 0;
        }
        for (int i = 0; i < nums.length ; i++) {
            if(target<=nums[i]){
                return i;
            }
        }
        return nums.length;
    }
}
