package com.tian.leetcode.code.com.tian;

import com.tian.shujujiegou.code1.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class Test1 {

    public static void main(String[] args){
        Test1 t = new Test1();
        int[] nums = {2,7,11,15};
        int[] result = t.twoSum3(nums,9);
        Util.printlnArray(result);
    }

    /**
     * 我的实现
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(result.length<2){
            return result;
        }
        for (int i =0 ; i<nums.length-1;i++){
            result[0] = i;
            for(int j = i+1;j< nums.length;j++ ){
                if(nums[i]+nums[j]==target){
                    result[1] = j;
                    return result;
                }

            }
        }
        return new int[2];
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        if(result.length<2){
            return result;
        }
        for (int i =0 ; i<nums.length-1;i++){
            int otherNum = target - nums[i];
            for(int j = i+1;j< nums.length;j++ ){
                if(otherNum==nums[j]){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 我能理解的最牛逼的实现
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            int otherNum = target - nums[i];
            if(map.containsKey(otherNum)){
                return new int[]{map.get(otherNum),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
