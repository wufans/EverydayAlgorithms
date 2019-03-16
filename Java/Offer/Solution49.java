/**
 * @Author: WuFan
 * @Date: 2019/3/16 14:39
 */

package offer;
/*
* 丑数
*
* 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。*/
public class Solution49 {
    public int GetUglyNumber_Solution(int index) {
        if(index < 6){
            return index;
        }
        int number2 = 0,number3 = 0,number5 = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int next2 = dp[number2]*2,next3 = dp[number3]*3,next5 = dp[number5]*5;
            dp[i] = Math.min(next2,Math.min(next3,next5));
            if(dp[i] == next2)
                number2++;
            if(dp[i] == next3)
                number3++;
            if(dp[i] == next5)
                number5++;
        }
        return dp[index-1];
    }
}
