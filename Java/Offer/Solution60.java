/**
 * @Author: WuFan
 * @Date: 2019/3/20 10:11
 */

package offer;

import java.util.*;

/*
* n 个骰子的点数
* 把 n 个骰子仍在地上，求点数和为 s 的概率。Throw n dices, the sum of the dices' faces is S. Given n, find the all possible value of S along with its probability.*/
public class Solution60 {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        //利用动态规划，dp[i][j]表示第i次掷骰子出现点数为j的次数。但是空间复杂度为O(n^2)
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[n + 1][pointNum + 1];
        for (int i = 1; i <= face; i++)
            dp[1][i] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = i; j <= pointNum; j++) /* 使用 i 个骰子最小点数为 i */
                for (int k = 1; k <= face && k <= j; k++)
                    dp[i][j] += dp[i - 1][j - k];
        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++)
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));
        return ret;
    }
    //利用动态规划+旋转数组的方式，相当于在前面动态规划的基础上，只用了2个数组，一个存放骰子为n的，一个存放骰子为n-1的
    public List<Map.Entry<Integer, Double>> dicesSum2(int n) {
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[2][pointNum + 1];
        for (int i = 1; i <= face; i++)
            dp[0][i] = 1;
        int flag = 1; /* 旋转标记*/
        for (int i = 2; i <= n; i++, flag = 1 - flag) {
            for (int j = 0; j <= pointNum; j++)
                dp[flag][j] = 0; /* 旋转数组清零 */
            for (int j = i; j <= pointNum; j++)
                for (int k = 1; k <= face && k <= j; k++)
                    dp[flag][j] += dp[1 - flag][j - k];
        }
        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++)
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[1 - flag][i]
                    / totalNum));
        return ret;
    }

}
