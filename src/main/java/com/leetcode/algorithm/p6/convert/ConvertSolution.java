package com.leetcode.algorithm.p6.convert;

public class ConvertSolution {


    public static String convert(String s, int numRows) {
        int n = s.length();
        if(numRows == 1 || numRows >=n){
            return s;
        }
        int t = numRows * 2 -2;
        int c = (n + t -1) / t * (numRows - 1);
        char[][] mat=new char[numRows][c];
        for(int i = 0,x = 0,y = 0;i < n; ++i){
            mat[x][y] = s.charAt(i);
            if(i % t < numRows - 1){
                ++x;
            }else{
                --x;
                ++y;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char[] row : mat){
            for(char ch : row){
                if(ch != 0){
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "ABCDEFG";
        int numRows = 3;
        String str = convert(s, numRows);
        System.out.println(str);
    }
}
