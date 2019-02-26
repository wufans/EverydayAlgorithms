/**
 * @Author: WuFan
 * @Date: 2019/2/26 16:01
 */

package offer;

import java.util.Arrays;

/*
* 1. 青蛙跳台阶
* 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶
总共有多少种跳法。
   2. 变态跳台阶
   一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青
蛙跳上一个 n 级的台阶总共有多少种跳法。
*/
public class Solution10_2 {
    public int JumpFloor(int n){
        if(n <=2){
            return n;
        }
        int fist = 1, last = 2;
        for(int i =2;i <= n;i++){
            last = fist + last;
            fist = last - fist;
        }
        return last;
//
//        if (n <= 2)
//            return n;
//        int pre2 = 1, pre1 = 2;
//        int result = 1;
//        for (int i = 2; i < n; i++) {
//            result = pre2 + pre1;
//            pre2 = pre1;
//            pre1 = result;
//        }
//        return result;
    }

    public int JumpFloorII(int target){
//        if(target <=2){
//            return target;
//        }
//        int number[] = new int[target];
//        number[0] = 1;
//        number[1] = 2;
//        int number_sum = 3;
//        for(int i = 2; i<= target-1;i++){
//            number[i] = number_sum + 1;
//            number_sum = number_sum*2 + 1;
//        }
//        return number[target-1];
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }
}
