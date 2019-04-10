/**
 * @Author: WuFan
 * @Date: 2019/4/10 10:21
 */

package leetcode;
/*
* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
*/
//这个题是剑指offer原题
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int temp_row = 0;
        int temp_col = col-1;
        while(temp_row < row && temp_col >= 0){
            if(matrix[temp_row][temp_col] > target){
                temp_col--;
            }else if(matrix[temp_row][temp_col] < target){
                temp_row++;
            }else{
                return true;
            }
        }
        return false;
    }
}
