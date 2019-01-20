/**
 * @Author: WuFan
 * @Date: 2019/1/20 15:12
 */

package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
* Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.*/
/*
* 不用解出这个九宫格，只需要判断当前存在的数是否符合条件即可，利用HashSet的特性：不可存在重复元素来解决。
将大的九宫格分为九个小宫格，行和列通过循环可以直接判断，每一小格（九宫格）是否不重复可以通过将i/3,j/3划分为同一个小宫格来判断是否重复。
- 5 in column 0可以被解读为第一列有数字5
- 6 in row 0可以解读为第一行有数字6
- 5 in block 0-0可以解读为第一个小宫格
*/
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;


    }
    public boolean isValidSudoku2(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int row = board.length;
        int col = board[0].length;

        int[] rowSet = new int[9];
        int[] colSet = new int[9];
        int[] blockSet = new int[9];

        for (int i =0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != '.') {
                    int idx = 1 << (board[i][j] - '0');

                    if ((rowSet[i] & idx) > 0 || (colSet[j] & idx) > 0 ||
                            (blockSet[((i/3)*3) + j/3] & idx) > 0) {
                        return false;
                    }

                    rowSet[i] |= idx;
                    colSet[j] |= idx;
                    blockSet[((i/3)*3) + j/3] |= idx;
                }
            }
        }

        return true;
        /*Set<String> number = new HashSet<String>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != '.'){
                    if (!number.add("number " + board[i][j] + "in row " + i) ||
                        !number.add("number " + board[i][j] + "in col " + j) ||
                        !number.add("number " + board[i][j] + "in block " + (i/3) + (j/3))) {
                        return false;
                    }
                }
            }
        }*/



        /*for (int i = 0 ; i < row; i++) {
            int result = 0;
            System.out.println("board[i][0]: " + result);
            for (int j = 0; j < col; j++) {
                if (board[i][j] != '.') {
                    result ^= (board[i][j] - '0');
                    System.out.println("board[i][j]: " + board[i][j] + ", result: " + result);
                }
            }

            if (result != 0) {
                return false;
            }
        }*/

        /*for (int i = 0 ; i < col; i++) {
            int result = board[0][i];
            for (int j = 1; j < row; j++) {
                result ^= board[j][i];
            }

            if (result != 0) {
                return false;
            }
        }*/


    }
}

