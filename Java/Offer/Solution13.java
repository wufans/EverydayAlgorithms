/**
 * @Author: WuFan
 * @Date: 2019/2/27 17:09
 */

package offer;
/*
* 机器人的运动范围
* 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次
只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于
k 的格子。
例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它
不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
*/


public class Solution13 {
    private int rows;
    private int cols;
    private int result = 0;
    private boolean[][] mark;
    public int movingCount(int threshold, int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.mark = new boolean[rows][cols];
        boolean[][] marktmp = new boolean[rows][cols];
        if(!(threshold <= 0 || rows <=0 || cols <=0)){
            helper(threshold,rows,cols,0,0,marktmp);
        }


        return result;
    }

    private void helper(int threshold, int rows, int cols, int r, int c, boolean[][] marktmp) {
        if(judge(threshold,r,c) && !marktmp[r][c]){
            System.out.println(Integer.toString(threshold)+" "+Integer.toString(r)+" "+Integer.toString(c));
            marktmp[r][c] = true;
            if(mark[r][c] == false){
                mark[r][c] = true;
                result++;
            }
            if(r+1 < rows){
                helper(threshold,rows,cols,r+1,c,marktmp);
            }
            if(c+1<cols){
                helper(threshold,rows,cols,r,c+1,marktmp);
            }
            if(r-1 >=0){
                helper(threshold,rows,cols,r-1,c,marktmp);
            }
            if(c-1 >=0){
                helper(threshold,rows,cols,r,c-1,marktmp);
            }
        }
    }

    private boolean judge(int threshold, int row, int col){
        int tmp = 0;
        while(row >0){
            tmp += row%10;
            row/=10;
        }
        while(col >0){
            tmp += col%10;
            col/=10;
        }
        return threshold >= tmp?true:false;
    }

    public static void main(String[] args) {
        Solution13 test = new Solution13();
        System.out.println(test.movingCount(5,10,10));
    }

//    private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1
//            , 0}};
//    private int cnt = 0;
//    private int rows;
//    private int cols;
//    private int threshold;
//    private int[][] digitSum;
//    public int movingCount(int threshold, int rows, int cols) {
//        this.rows = rows;
//        this.cols = cols;
//        this.threshold = threshold;
//        initDigitSum();
//        boolean[][] marked = new boolean[rows][cols];
//        dfs(marked, 0, 0);
//        return cnt;
//    }
//    private void dfs(boolean[][] marked, int r, int c) {
//        if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c]
//        )
//            return;
//        marked[r][c] = true;
//        System.out.println(Integer.toString(threshold)+" "+Integer.toString(r)+" "+Integer.toString(c));
//        if (this.digitSum[r][c] > this.threshold)
//            return;
//        cnt++;
//        for (int[] n : next)
//            dfs(marked, r + n[0], c + n[1]);
//    }
//    private void initDigitSum() {
//        int[] digitSumOne = new int[Math.max(rows, cols)];
//        for (int i = 0; i < digitSumOne.length; i++) {
//            int n = i;
//            while (n > 0) {
//                digitSumOne[i] += n % 10;
//                n /= 10;
//            }
//        }
//        this.digitSum = new int[rows][cols];
//        for (int i = 0; i < this.rows; i++)
//            for (int j = 0; j < this.cols; j++)
//                this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j
//                        ];
//    }
}
