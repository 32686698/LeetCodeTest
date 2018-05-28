package com.tian.leetcode.code.com.tian;

import java.util.ArrayList;
import java.util.List;

public class Test39 {
    public static void main(String[] args) {
        Test39 t = new Test39();
        int [] aa = new int[]{7,6,3,2};
        List<List<Integer>> a = t.combinationSum(aa,7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for(int i = 0 ; i < candidates.length; i ++){
            for(int j = 0 ;j < candidates.length-i-1;j++){
                if(candidates[j]>candidates[j+1]){
                    int temp = candidates[j+1];
                    candidates[j+1] = candidates[j];
                    candidates[j] = temp;
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0 ; i <candidates.length; i ++){
            if(candidates[i]>target)break;
            List<Integer> list = new ArrayList<>();
            int count = 0;
//            while (count>)---------------
            list.add(candidates[i]);
            count += candidates[i];
        }


        return null;
    }
}
