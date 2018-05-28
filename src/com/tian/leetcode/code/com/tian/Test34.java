package com.tian.leetcode.code.com.tian;

public class Test34 {

    public static void main(String[] args) {
        Test34 t = new Test34();
        int[] a = t.searchRange(new int[]{5,7,7,8,8,10},99);
        System.out.println(a[0]+","+a[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int i = 0 ,j = nums.length-1;
        int m=-1,n=-1;
        while (i<=j){
            if(nums[i]==target&&m==-1)m=i;
            if(nums[j]==target&&n==-1)n=j;
            if(m!=-1&&n!=-1){
                break;
            }
            if(nums[i]<target){
                i++;
            }else if(nums[j]>target){
                j--;
            }
        }

        return new int[]{m,n};
    }
}
