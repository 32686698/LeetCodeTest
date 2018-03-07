package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.ListNode;
import com.tian.shujujiegou.code1.Util;

/**
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class Test88 {

    public static void main(String[] args) {
        Test88 t = new Test88();
        int m = 3,n = 5;
        int[] nums1 = {2,4,6,0,0,0,0,0};
        int[] nums2 = {1,3,5,7,9};
        t.merge2(nums1,m,nums2,n);
        Util.printlnArray(nums1);
    }

    /**
     * 我的实现
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i2 = 0;
        int countL = m+n;
        for (int i = 0; i < countL ; i++) {
            for (; i2 < n;) {
                if(nums1[i]>nums2[i2]){
                    for (int j = m; j > i; j--) {
                        nums1[j] = nums1[j-1];
                    }
                    nums1[i] = nums2[i2];
                    i2 ++;
                    i++;
                    m++;
                }else{
                    break;
                }

            }

        }
        if(i2<n){
            for (int i = countL -1,j=0; j <n-i2 ; i--,j++) {
                nums1[i] = nums2[n-1-j];
            }
        }
    }


    /**
     * 我的实现2
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m+n];
        int countL = m+n;
        int n1Index = 0;
        int n2Index = 0;
        for (int i = 0; i < countL; i++) {
            //增加nums2多的
            if(n1Index==m){
                nums3[i] = nums2[n2Index++];
                continue;
            }
            //增加nums2多的
            if(n2Index==n){
                nums3[i] = nums1[n1Index++];
                continue;
            }
            if(nums1[n1Index]<nums2[n2Index]){
                nums3[i] = nums1[n1Index++];
            }else if(nums1[n1Index]==nums2[n2Index]){
                nums3[i] = nums1[n1Index++];
                i++;
                nums3[i] = nums2[n2Index++];
            }else if(nums1[n1Index]>nums2[n2Index]){
                nums3[i] = nums2[n2Index++];
            }
        }
        for (int i = 0; i < countL; i++) {
            nums1[i] = nums3[i];
        }
    }


    /**
     * 牛逼的实现  从nums1最后往前推
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int last = m+n-1;
        int first = m - 1;
        int second = n - 1;

        while (first >= 0 && second >= 0) {
            if (nums1[first] > nums2[second]) {
                nums1[last] = nums1[first];
                first--;
            } else {
                nums1[last] = nums2[second];
                second--;
            }
            last--;
        }

        if (first < 0) {
            for (int i = 0; i <= last; i++) {
                nums1[i] = nums2[i];
            }
        }

    }
}
