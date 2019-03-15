/**
 * @Author: WuFan
 * @Date: 2019/3/15 20:25
 */

package offer;
/*
* 礼物的最大价值
* 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（ 大于
0） 。从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一
个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘*/
public class Solution47 {
    private int price=0;
    public int getMost(int[][] values) {
        if(values.length == 0 || values[0].length == 0)
            return 0;
        dp(values,0,0,values.length-1, values[0].length-1, 0);
        return price;
    }
    public void dp(int[][] values, int now_i, int now_j, int i, int j, int now_price){
        now_price += values[now_i][now_j];
        if(now_i == i && now_j == j){
            System.out.println(now_price);
            price = price>now_price?price:now_price;
            return;
        }
        if(now_i+1<=i){
            dp(values,now_i+1,now_j,i,j,now_price);
            //now_price -= values[now_i+1][now_j];//值传递，不改变对象。。
        }
        if(now_j+1<=j) {
            dp(values, now_i, now_j + 1, i, j, now_price);
            //now_price -= values[now_i][now_j + 1];//值传递，不改变对象。。
        }

        //动态规划的方法
//        for(int i = 0 ; i<board.length ; i++){
//            for(int j = 0 ; j <board[0].length ; j++){
//                if(i==0&&j==0){
//                    //如果是起点坐标，不做任何处理。
//                }else if(i == 0){
//                    //如果走在行的临界边，也就是第一行，那么他只能向右走
//                    //向右走的时候该点就要将后面的值加起来。
//                    board[i][j] += board[i][j-1];
//                }else if(j == 0){
//                    //如果走在列的临界边，也就是第一列，那么他只能向下走
//                    //向下走的时候该点就要将上面的值加起来。
//                    board[i][j] += board[i-1][j];
//                }else{
//                    //核心点在这，除去两个临界边，剩下的就是既能向右走，也能向下走，
//                    //那么这时候就要考虑走到当前点的所有可能得情况，也就是走到当前点
//                    //各自路径的和是不是这些所有到达该点路径当中最大的了。
//                    //temup用来存储从该点上面走下来的最大路径和。
//                    //templeft用来存储从该点左边走过来的最大路径的和，
//                    int temup = board[i-1][j];
//                    int templeft = board[i][j-1];
//                    //这两者肯定只能选其一，进行比较，那个大，就把这个值加给当前点，
//                    //因为从一开始我们就进行了大小的比较，每一个点存储的都是到达当前点
//                    //的最大值。所以直到最后一个点为止，她的值就是当前最大值的和。只要返回
//                    //最后一个点的内容就可以了。
//                    if(temup>templeft){
//                        board[i][j] +=temup ;
//                    }else{
//                        board[i][j] +=templeft;
//                    }
//                }
//            }
    }

    public static void main(String[] args) {
        Solution47 test = new Solution47();
        System.out.println(test.getMost(new int[][]{{1,2},{1,2},{1,2},{1,2}}));
    }
}
