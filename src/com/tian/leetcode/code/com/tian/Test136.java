package com.tian.leetcode.code.com.tian;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/single-number/description/
 */
public class Test136 {

    public static void main(String[] args){
        Test136 t = new Test136();
        int[] nums = new int[]{1,1,2,2,3,4,3,6,4};
        int re = t.singleNumber(nums);
        System.out.println(re);
    }

    /**
     * 我的实现
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int  num : nums){
           if(list.contains(num)){
               list.remove(new Integer(num));
           }else{
               list.add(new Integer(num));
           }
        }
        return list.get(0);
    }

    /**
     * 牛逼的实现
     * 位异或运算（^）
     * 运算规则是：两个数转为二进制，然后从高位开始比较，如果相同则为0，不相同则为1。
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++)
            ans=ans^nums[i];

        return ans;
    }
}

