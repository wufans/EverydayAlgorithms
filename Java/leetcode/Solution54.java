/**
 * @Author: WuFan
 * @Date: 2019/4/6 9:45
 */

package leetcode;
/*
* Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]*/
import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public static void main(String[] args) {

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length<=0||matrix[0].length<=0)
            return res;
        int row_min = 0, row_max = matrix.length-1;
        int col_min = 0, col_max = matrix[0].length-1;

        while(row_min <= row_max && col_min <= col_max){

            for (int i = col_min; i <= col_max ; i++) {
                res.add(matrix[row_min][i]);
            }
            for (int i = row_min +1; i <= row_max; i++) {
                res.add(matrix[i][col_max]);
            }
            if(row_min != row_max){
                for (int i = col_max-1; i >= col_min ; i--) {
                    res.add(matrix[row_max][i]);
                }
            }
            if(col_max != col_min){
                for (int i = row_max-1; i > row_min ; i--) {
                    res.add(matrix[i][col_min]);
                }
            }
            row_max--;row_min++;col_max--;col_min++;
        }

        return res;
    }
}
