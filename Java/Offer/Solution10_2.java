/**
 * @Author: WuFan
 * @Date: 2019/2/26 16:01
 */

package offer;
/*
* 跳台阶
* 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶
总共有多少种跳法。*/
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
}
