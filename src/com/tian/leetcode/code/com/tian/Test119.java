package com.tian.leetcode.code.com.tian;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 */
public class Test119 {

    public static void main(String[] args) {
        Test119 t = new Test119();
        List<Integer> list = t.getRow(0);
        System.out.println(list);
    }

    /**
     * 我的实现
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        rowIndex ++;
        List<Integer> last = new ArrayList<>();
        if (rowIndex == 0) {
            return last;
        }
        last.add(1);
        if (rowIndex == 1) {
            return last;
        }
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                } else {
                    list.add(last.get(j - 1) + last.get(j));
                }
            }
            last = list;
        }
        return last;
    }


    /**
     * 牛逼的实现
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow2(int rowIndex) {
        if(rowIndex < 0) {
            return null;
        }

        List<Integer> row = new ArrayList<Integer>();
        row.add(1);

        int n = rowIndex;
        int k = 1;
        long val = n/k;

        while(k <= rowIndex){
            row.add((int)val);
            --n;
            ++k;

            val *= n;
            val /= k;
        }
        return row;
    }
}
