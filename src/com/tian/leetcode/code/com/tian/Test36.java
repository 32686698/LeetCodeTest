package com.tian.leetcode.code.com.tian;

import java.util.HashSet;
import java.util.Set;

public class Test36 {
    public static void main(String[] args) {
        Test36 t = new Test36();
        char[][] board = new char[9][9];
        int k = 0;
        board[k++] = new char[]{'.','.','.','.','.','.','5','.','.'};
        board[k++] = new char[]{'.','.','.','.','.','.','.','.','.'};
        board[k++] = new char[]{'.','.','.','.','.','.','.','.','.'};
        board[k++] = new char[]{'9','3','.','.','2','.','4','.','.'};
        board[k++] = new char[]{'.','.','7','.','.','.','3','.','.'};
        board[k++] = new char[]{'.','.','.','.','.','.','.','.','.'};
        board[k++] = new char[]{'.','.','.','3','4','.','.','.','.'};
        board[k++] = new char[]{'.','.','.','.','.','3','.','.','.'};
        board[k++] = new char[]{'.','.','.','.','.','5','2','.','.'};

        boolean b = t.isValidSudoku(board);
        System.out.println(b);
    }

    /**
     * 我的实现
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0 ,j = 0; i < 9;i++,j++){
            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            for(int k = 0 ; k < 9 ; k++){
                if(board[i][k]!='.'){
                    if(set1.contains(board[i][k])){
                        return false;
                    }
                    set1.add(board[i][k]);
                }
                if(board[k][j]!='.'){
                    if(set2.contains(board[k][j])){
                        return false;
                    }
                    set2.add(board[k][j]);
                }
            }
            if(i%3==0){
                Set<Character> set11 = new HashSet<>();
                Set<Character> set22 = new HashSet<>();
                Set<Character> set33 = new HashSet<>();
                for(int k = i;k-i<3;k++){
                    for(int m = 0; m < 9;m++){
                        if(board[k][m]=='.'){
                            continue;
                        }
                        if(m/3==0){
                            if(set11.contains(board[k][m])){
                                return false;
                            }
                            set11.add(board[k][m]);
                        }else if(m/3==1){
                            if(set22.contains(board[k][m])){
                                return false;
                            }
                            set22.add(board[k][m]);
                        }else if(m/3==2){
                            if(set33.contains(board[k][m])){
                                return false;
                            }
                            set33.add(board[k][m]);
                        }
                    }
                }
            }
        }
        return true;
    }


    /**
     * 牛逼的实现
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        int[][] signs = new int[3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int n = 1 << (board[i][j] - '1');
                int cubeIndex = i / 3 * 3 + j / 3;
                if ((signs[0][i] & n) != 0 || (signs[1][j] & n) != 0 || (signs[2][cubeIndex] & n) != 0)
                    return false;
                signs[0][i] |= n;
                signs[1][j] |= n;
                signs[2][cubeIndex] |= n;
            }
        }
        return true;
    }
}
