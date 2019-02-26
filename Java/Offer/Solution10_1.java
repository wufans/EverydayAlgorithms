/**
 * @Author: WuFan
 * @Date: 2019/2/26 9:48
 */

package offer;
/*
* 动态规划
* 斐波那契数列
* 求斐波那契数列的第 n 项，n <= 39。
*/
public class Solution10_1 {
    // 1. 斐波那契数列
    //   求斐波那契数列的第 n 项，n <= 39。
    //递归解法（会重复求解子问题，造成时间和空间的浪费）
    public int Fibonacci(int n){
        if(n <= 1){
            return n;
        }
        else{
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }
    //动态规划（会把已经求解的子问题缓存起来）
    public int Fibonacci2(int n){
//        if(n <= 1){
//            return n;
//        }
//        int fibn_1 = 0;
//        int fibn = 1;
//        for(int i = 2; i<=n ;i++){
//            fibn = fibn_1 + fibn;
//            fibn_1 = fibn - fibn_1;
//        }
//        return fibn;
//
//        if (n <= 1)
//            return n;
//        int pre2 = 0, pre1 = 1;
//        int fib = 0;
//        for (int i = 2; i <= n; i++) {
//            fib = pre2 + pre1;
//            pre2 = pre1;
//            pre1 = fib;
//        }
//        return fib;

        if (n <= 1)
            return n;
        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
        return fib[n];
    }

    public static void main(String[] args) {
        Solution10_1 test = new Solution10_1();
        System.out.println(test.Fibonacci2(39));
    }
}
