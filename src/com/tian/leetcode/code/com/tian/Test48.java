package com.tian.leetcode.code.com.tian;

import com.tian.leetcode.code.com.tian.util.ArraysUtil;

public class Test48 {

    public static void main(String[] args) {
        Test48 t = new Test48();
        int [] [] matrix = { {1} };
        t.rotate(matrix);
        ArraysUtil.printArrays(matrix);
    }

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for(int i = 0,j=0;i<length/2;i++,j++){
            for(int ii=0;ii<(length+1)/2;ii++){
                int[] currentNums = {i,ii};
                int k = 1;
                int temp1 = matrix[currentNums[0]][currentNums[1]];
                int temp2 ;
                while (k++<= 4){
                    int[] nums = {currentNums[1],length-1-currentNums[0]};
                    temp2 = matrix[nums[0]][nums[1]];
                    matrix[nums[0]][nums[1]] = temp1;
                    temp1 = temp2;

                    currentNums = nums;
                }
            }
        }
    }

    public void rotate2(int[][] matrix) {

        int n=matrix[0].length-1;
        for(int i=0;i<=n/2;i++){//需要交换位子的层数  i是交换该层的左边界 n-1-i是右边界
            for(int j=0;j<(n+1)/2;j++){//每次点交换lenght-1次
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-j][i];
                matrix[n-j][i]= matrix[n-i][n-j];
                matrix[n-i][n-j]=matrix[j][n-i];
                matrix[j][n-i]=temp;
            }

        }
    }
}
