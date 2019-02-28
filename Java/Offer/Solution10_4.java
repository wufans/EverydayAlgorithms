/**
 * @Author: WuFan
 * @Date: 2019/2/27 22:42
 */

package offer;
/*
* 背包问题
* 一个背包的总容量为V,现在有N类物品,第i类物品的重量为weight[i],价值为value[i]
那么往该背包里装东西,怎样装才能使得最终包内物品的总价值最大。这里装物品主要由三种装法：
1、0-1背包：每类物品最多只能装一次
2、多重背包：每类物品都有个数限制，第i类物品最多可以装num[i]次
3、完全背包：每类物品可以无限次装进包内
---------------------
原文：https://blog.csdn.net/lanyu_01/article/details/79815801
* */
public class Solution10_4 {
    //0-1背包问题
    /**
     * 0-1背包问题
     * @param V 背包容量
     * @param N 物品种类
     * @param weight 物品重量
     * @param value 物品价值
     * @return
     */
    public static String ZeroOnePack(int V,int N,int[] weight,int[] value){
//别人的解法
//        //初始化动态规划数组
//        int[][] dp = new int[N+1][V+1];
//        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
//        for(int i=1;i<N+1;i++){
//            for(int j=1;j<V+1;j++){
//                //如果第i件物品的重量大于背包容量j,则不装入背包
//                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
//                if(weight[i-1] > j)
//                    dp[i][j] = dp[i-1][j];
//                else
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
//            }
//        }
//        //则容量为V的背包能够装入物品的最大值为
//        int maxValue = dp[N][V];
//        //逆推找出装入背包的所有商品的编号
//        int j=V;
//        String numStr="";
//        for(int i=N;i>0;i--){
//            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
//            if(dp[i][j]>dp[i-1][j]){
//                numStr = i+" "+numStr;
//                j=j-weight[i-1];
//            }
//            if(j==0)
//                break;
//        }
//        return numStr;

        //利用动态规划，状态转移的求解方法-My Solution
        int[][] dp = new int[N+1][V+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if(weight[i-1] > j ){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }

        int maxValue = dp[N][V];
        return Integer.toString(maxValue);


    }
    /**
     * 0-1背包的优化解法
     * 思路：
     * 只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
     * 用逆序来实现
     */
    public static int ZeroOnePack2(int V,int N,int[] weight,int[] value){
        //动态规划
        int[] dp = new int[V+1];
        for(int i=1;i<N+1;i++){
            //逆序实现
            for(int j=V;j>=weight[i-1];j--){
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
            }
        }
        return dp[V];
    }

    /**
     * 第二类背包：多重背包
     *
     * @param args
     */
    public static int manyPack(int V,int N,int[] weight,int[] value,int[] num){
        //初始化动态规划数组
        int[][] dp = new int[N+1][V+1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if(weight[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else{
                    //考虑物品的件数限制,每一个状态迭代都考虑放置第i个物品的不同数量的问题。
                    //也就是将分支增加了，考虑到放一件，放2件等分支。
                    int maxV = Math.min(num[i-1],j/weight[i-1]);
                    for(int k=0;k<maxV+1;k++){
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-k*weight[i-1]]+k*value[i-1]);
                    }
                }
            }
        }
        /*//则容量为V的背包能够装入物品的最大值为
        int maxValue = dp[N][V];
        int j=V;
        String numStr="";
        for(int i=N;i>0;i--){
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            while(dp[i][j]>dp[i-1][j]){
                numStr = i+" "+numStr;
                j=j-weight[i-1];
            }
            if(j==0)
                break;
        }*/
        return dp[N][V];
    }
    /**
     * 第三类背包：完全背包
     * 思路分析：
     * 01背包问题是在前一个子问题（i-1种物品）的基础上来解决当前问题（i种物品），
     * 向i-1种物品时的背包添加第i种物品；而完全背包问题是在解决当前问题（i种物品）
     * 向i种物品时的背包添加第i种物品。
     * 推公式计算时，f[i][y] = max{f[i-1][y], (f[i][y-weight[i]]+value[i])}，
     * 注意这里当考虑放入一个物品 i 时应当考虑还可能继续放入 i，
     * 因此这里是f[i][y-weight[i]]+value[i], 而不是f[i-1][y-weight[i]]+value[i]。
     * @param V
     * @param N
     * @param weight
     * @param value
     * @return
     */
    public static String completePack(int V,int N,int[] weight,int[] value){
        //初始化动态规划数组
        int[][] dp = new int[N+1][V+1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if(weight[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weight[i-1]]+value[i-1]);
            }
        }
        //则容量为V的背包能够装入物品的最大值为
        int maxValue = dp[N][V];
        int j=V;
        String numStr="";
        for(int i=N;i>0;i--){
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            while(dp[i][j]>dp[i-1][j]){
                numStr = i+" "+numStr;
                j=j-weight[i-1];
            }
            if(j==0)
                break;
        }
        return numStr;
    }
    /**
     * 完全背包的第二种解法
     * 思路：
     * 只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
     * 用顺序来实现
     */
    public static int completePack2(int V,int N,int[] weight,int[] value){

        //动态规划
        int[] dp = new int[V+1];
        for(int i=1;i<N+1;i++){
            //顺序实现
            for(int j=weight[i-1];j<V+1;j++){
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
            }
        }
        return dp[V];
    }

    public static void main(String[] args) {
        Solution10_4 test = new Solution10_4();

        System.out.println(test.ZeroOnePack(5,3,new int[]{1,2,3},new int[]{2,3,4}));
    }
}
