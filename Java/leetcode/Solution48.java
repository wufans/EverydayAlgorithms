/**
 * @Author: WuFan
 * @Date: 2019/2/18 23:42
 */

package leetcode;
/*
* You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]*/
//三种解法：
//1.对于当前位置，计算旋转后的新位置，然后再计算下一个新位置，第四个位置又变成当前位置了，所以这个方法每次循环换四个数字
//2.首先以从对角线为轴翻转，然后再以x轴中线上下翻转即可得到结果
//3.首先对原数组取其转置矩阵，然后把每行的数字翻转可得到结果
public class Solution48 {
    //解法3，beats 100%
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for(int index = 0;index < length;index ++){
            for(int indexj = index; indexj < length;indexj++){
                int temp = matrix[index][indexj];
                matrix[index][indexj] = matrix[indexj][index];
                matrix[indexj][index] = temp;
            }
        }
        for(int index = 0;index < length; index ++){
            for(int indexj = 0;indexj < length/2;indexj++){
                int temp = matrix[index][indexj];
                matrix[index][indexj] = matrix[index][length -1- indexj] ;
                matrix[index][length-1 - indexj] = temp;
            }
        }
    }
}
