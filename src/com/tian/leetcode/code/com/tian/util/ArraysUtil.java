package com.tian.leetcode.code.com.tian.util;

public class ArraysUtil {

    public static void printArray(int[] args) {
        for (int o:args){
            System.out.print(o+" ,");
        }
    }

    public static void printArrays(int[][] args) {
        for (int[] os:args){
            for(int o:os){
                System.out.print(o+" ,");
            }
            System.out.println();
        }
    }
}
