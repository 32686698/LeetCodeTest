package com.tian.leetcode.code.com.tian;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class Test167 {

    public static void main(String[] args) {
        Test167 t = new Test167();
        int[] a = t.twoSum(new int[]{2, 7, 11, 14}, 9);
        for (int b : a) {
            System.out.println(b);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<numbers.length;i++){
            int cha = target -numbers[i];
            if(map.containsKey(cha)){
                return new int[]{map.get(cha)+1,i+1};
            }
            map.put(numbers[i],i);
        }
        return null;
    }


    /**
     * 牛逼的实现 两边夹击
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {

        int low = 0 , high = numbers.length-1;
        while(numbers[low]+numbers[high]!=target){
            if(numbers[low]+numbers[high]>target) high--;
            if(numbers[low]+numbers[high]<target) low++;
        }

        return new int[]{low+1,high+1};
    }
}
