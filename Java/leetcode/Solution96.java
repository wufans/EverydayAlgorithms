package leetcode;

/**
 * @Author: wufan
 * @Date: 2019/8/1 10:46
 */
public class Solution96 {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
    public static int numTrees(int n) {
        if(n == 0){
            return 1;
        }
        if(n <= 2){
            return n;
        }
        int res = 0;
        for (int i = 1; i <= n ; i++) {
            res = res + numTrees(i-1)*numTrees(n-i);
        }
        return res;
    }
    //100% 动态规划的方法，适合需要短暂存储中间值的运算
    public int numTrees2(int n) {
        int [] dp = new int[n+1];
        dp[0]= 1;
        dp[1] = 1;
        for(int level = 2; level <=n; level++)
            for(int root = 1; root<=level; root++)
                dp[level] += dp[level-root]*dp[root-1];
        return dp[n];
    }
}
