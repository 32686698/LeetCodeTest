package com.tian.leetcode.code.com.tian;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/submissions/detail/151245463/
 */
public class Test169 {

    public  static  void  main(String[] args){
        Test169 t = new Test169();
        int a = t.majorityElement(new int[]{1,1,2,2,2});
        System.out.println(a);
    }

    /**
     * 我的实现
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        if(nums.length==1)
            return nums[0];
        int hf = nums.length/2 + nums.length%2;
        for(int x:nums){
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
                if(map.get(x)>=hf)
                    return x;
            }else {
                map.put(x,1);
            }
        }
        return 0;
    }

    /**
     * 牛逼的实现 ，想法很牛逼啊
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
