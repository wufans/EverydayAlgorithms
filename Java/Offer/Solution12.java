/**
 * @Author: WuFan
 * @Date: 2019/2/27 16:00
 */

package offer;
/*
* 矩阵中的路径
* 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路
径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向
上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能
再进入该格子。*/
public class Solution12 {

    //private boolean[] mark =
    private int rows;
    private int cols;
    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        //异常情况判断
        if(array.length == 0 || array.length != rows * cols){
            return false;
        }
        if(str.length == 0){
            return true;
        }
        char[][] matrix = new char[rows][cols];
        boolean[][] mark = new boolean[rows][cols];

        this.rows = rows;
        this.cols = cols;
        //把一维数组转化成二维矩阵
        for (int r = 0, idx = 0; r < rows; r++) {  //注意括号内的inx的定义方式
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = array[idx++];
            }
        }
        //遍历数组每个元素，依次与字符串比较
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == str[0]) {
                    mark[r][c] = true;
                    if(helper(matrix, r, c, str,mark, 0)){
                        return true;
                    }
                    mark[r][c] = false;
                }
            }

        }
        return false;
    }

    //回溯算法的主体，依次迭代，直到最后的结论；
    private boolean helper(char[][] matrix, int r, int c, char[] str,boolean[][] mark, int number) {

        if(number == str.length-1){
            return true;
        }
        number += 1;
        if(r-1 >=0){
            if(matrix[r-1][c] == str[number] && !mark[r-1][c]){
                mark[r-1][c] = true;
                if(helper(matrix, r-1, c, str, mark, number)){
                    return true;
                }
            }
        }
        if(r+1 < rows){
            if(matrix[r+1][c] == str[number] && !mark[r+1][c]){
                mark[r+1][c] = true;

                if(helper(matrix, r+1, c, str, mark, number)){
                    return true;
                }
            }
        }
        if(c-1 >= 0){
            if(matrix[r][c-1] == str[number] && !mark[r][c-1]){
                mark[r][c-1] = true;
                if(helper(matrix, r, c-1, str, mark, number)){
                    return true;
                }
            }
        }
        if(c+1 < cols){
            if(matrix[r][c+1] == str[number] && !mark[r][c+1]){
                mark[r][c+1] = true;
                if(helper(matrix, r, c+1, str, mark, number)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution12 test = new Solution12();
        char[] matrix = {'a','b','c','e',
                        's','f','c','s',
                        'a','e','e','e'};
        char[] str = {'b','c','c','e','d'};
        //System.out.println(test.hasPath(matrix,3,4,str));
        System.out.println(test.hasPath((
                        "ABCEHJIG" +
                        "SFCSLOPQ" +
                        "ADEEMNOE" +
                        "ADIDEJFM" +
                        "VCEIFGGS").toCharArray(),5,8,"SGGFIECVAASABCEHJIGQEM".toCharArray()));
    }
//    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1
//            , 0}};
//    private int rows;
//    private int cols;
//    public boolean hasPath(char[] array, int rows, int cols, char[]
//            str) {
//        if (rows == 0 || cols == 0)
//            return false;
//        this.rows = rows;
//        this.cols = cols;
//        boolean[][] marked = new boolean[rows][cols];
//        char[][] matrix = buildMatrix(array);
//        for (int i = 0; i < rows; i++)
//            for (int j = 0; j < cols; j++)
//                if (backtracking(matrix, str, marked, 0, i, j))
//                    return true;
//        return false;
//    }
//    private boolean backtracking(char[][] matrix, char[] str, boolean
//            [][] marked, int pathLen, int r, int c) {
//        if (pathLen == str.length)
//            return true;
//        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c]
//                != str[pathLen] || marked[r][c])
//            return false;
//        marked[r][c] = true;
//        for (int[] n : next)
//            if (backtracking(matrix, str, marked, pathLen + 1, r + n[
//                    0], c + n[1]))
//                return true;
//        marked[r][c] = false;
//        return false;
//    }
//    private char[][] buildMatrix(char[] array) {
//        char[][] matrix = new char[rows][cols];
//        for (int i = 0, idx = 0; i < rows; i++)
//            for (int j = 0; j < cols; j++)
//                matrix[i][j] = array[idx++];
//        return matrix;
//    }
}


