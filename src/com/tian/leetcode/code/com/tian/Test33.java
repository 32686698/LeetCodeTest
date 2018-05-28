package com.tian.leetcode.code.com.tian;

public class Test33 {

    public static void main(String[] args) {
        Test33 t = new Test33();
        int a = t.search(new int[]{4,5,6,7,0,1,2},8);
        System.out.println(a);
    }

    /**
     * 我的实现
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int i = 0,j = nums.length - 1;
        while (i<=j){
            if(nums[i]==target) return i;
            if(nums[j]==target) return j;
            if(nums[i]>target&&nums[j]<target){
                return -1;
            }else if(nums[i]<target){
                i++;
            }else if(nums[i]>target&&nums[j]>target){
                j--;
            }
        }
        return -1;
    }
}
