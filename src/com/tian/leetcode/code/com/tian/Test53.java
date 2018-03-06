package com.tian.leetcode.code.com.tian;


/**
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class Test53 {
    public static  void main(String[] args){
        Test53 t = new Test53();
        int tt = t.maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(tt);
    }

    /**
     * 我的实现 超时
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if(max<sum) {
                max = sum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if(max<sum) {
                    max = sum;
                }
            }
        }
        return max;
    }


    /**
     * O(n)的实现 牛逼的实现,想法很牛逼
     * @param A
     * @return
     */
    public int maxSubArray2(int[] A) {
        int maxSoFar=A[0];
        int maxEndingHere=A[0];
        for (int i=1;i<A.length;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
