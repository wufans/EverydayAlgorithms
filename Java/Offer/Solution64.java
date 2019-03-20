/**
 * @Author: WuFan
 * @Date: 2019/3/20 15:25
 */

package offer;
/*
* 求 1+2+3+...+n
* 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。*/
public class Solution64 {
    public int Sum_Solution(int n) {
        //这个题目的主要内容：
        // （1）递归
        // （2）用&&实现短路
        int res = n;
        boolean b = (n>0)&&(res += Sum_Solution(n-1))>0;
        return res;
    }
}
