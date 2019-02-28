/**
 * @Author: WuFan
 * @Date: 2019/2/28 15:53
 */

package offer;
/*
* 剪绳子
* 把一根绳子剪成多段，并且使得每段的长度乘积最大。
n = 2
return 1 (2 = 1 + 1)
n = 10
return 36 (10 = 3 + 3 + 4)*/
public class Solution14 {

    /*
    * 尽可能多剪长度为 3 的绳子，并且不允许有长度为 1 的绳子出现。如果出现了，就
从已经切好长度为 3 的绳子中拿出一段与长度为 1 的绳子重新组合，把它们切成两
段长度为 2 的绳子。*/
    public int integerBreak(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1)
            timesOf3--;
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }
    //动态规划
    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j]* (i - j)));
        return dp[n];
    }
}
