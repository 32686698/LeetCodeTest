package com.tian.leetcode.code.com.tian;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/description/
 */
public class Test118 {

    public static void main(String[] args){
        Test118 t = new Test118();
        List<List<Integer>> list = t.generate(5);
        System.out.println(list);
    }

    /**
     * 我的实现
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows==0){
            return result;
        }
        List<Integer> last = new ArrayList<>();
        last.add(1);
        result.add(last);
        if(numRows==1){
            return result;
        }
        for(int i = 2 ; i <= numRows ; i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0;j<i;j++){
                if(j==0||j==i-1){
                    list.add(1);
                }else{
                    list.add(last.get(j-1)+last.get(j));
                }
            }
            result.add(list);
            last = list;
        }
        return result;
    }
}
