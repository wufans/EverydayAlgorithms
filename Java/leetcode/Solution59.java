/**
 * @Author: WuFan
 * @Date: 2019/4/7 10:21
 */

package leetcode;


import java.util.Arrays;

/*
* Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]*/
public class Solution59 {
    public static void main(String[] args) {
        for(int[] i:generateMatrix(3)){
            System.out.println(Arrays.toString(i));
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int row_min = 0, row_max = n-1;
        int col_min = 0, col_max = n-1;
        int temp_num = 1;
        while(row_min <= row_max && col_min <= col_max){
            for (int i = col_min; i <= col_max ; i++) {
                res[row_min][i] = temp_num++;
            }
            for (int i = row_min + 1; i <= row_max ; i++) {
                res[i][col_max] = temp_num++;
            }
            if(row_max>row_min){
                for (int i = col_max-1; i >= col_min ; i--) {
                    res[row_max][i] = temp_num++;
                }
            }
            if(col_max>col_min){
                for (int i = row_max -1 ; i >row_min ; i--) {
                    res[i][row_min] = temp_num++;
                }
            }
            row_min++;row_max--;col_max--;col_min++;
        }
        return res;
    }
    //相似的解法
    public int[][] generateMatrix2(int n) {
        int[][]end=new int[n][n];
        int val=1;
        int num=n*n;
        int col=0;//行
        int row=0;//列
        int roll=0;//转数
        while(num>0){
            while(row<n-roll){
                end[col][row]=val;
                val++;
                row++;
                num--;
            }
            row--;
            col++;

            while(col<n-roll){
                end[col][row]=val;
                val++;
                col++;
                num--;
            }
            col--;
            row--;

            while(row>=roll){
                end[col][row]=val;
                val++;
                row--;
                num--;
            }
            row++;
            col--;

            while(col>roll){
                end[col][row]=val;
                val++;
                col--;
                num--;
            }
            col++;
            row++;
            roll++;

        }
        return end;
    }
}
