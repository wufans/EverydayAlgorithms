/**
 * @Author: WuFan
 * @Date: 2019/3/31 11:07
 */

package leetcode;
/*
* Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]*/
public class Solution50 {
    public double myPow(double x, int n) {
//        Wrong answer，StackOverFlow.
//        if(n == 1){
//            return x;
//        }
//        if(n==0){
//            return 1;
//        }
//        if(n<0){
//            if(x == 0){
//                return 0;
//            }else{
//                return 1/myPow(x,-n);
//            }
//        }
//        return myPow(x,n-1)*x;

        //把一个数的阶乘转变成求 a·x^1+b·x^2+c·x^3...的问题。
        double ans = 1;
        long absN = Math.abs((long)n);
        while(absN > 0) {
            if((absN&1)==1) ans *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }
}
