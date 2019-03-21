/**
 * @Author: WuFan
 * @Date: 2019/3/21 13:49
 */

package offer;

import java.math.BigInteger;

/*
*不用加减乘除做加法
* 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。*/
public class Solution65 {
    /*方法1：使用BigInteger类*/
    public int Add(int num1,int num2) {
        BigInteger b1 = new BigInteger(Integer.toString(num1));
        BigInteger b2 = new BigInteger(Integer.toString(num2));
        //return Integer.valueOf(b1.add(b2).toString());
        return b1.add(b2).intValue();
    }

    /*方法2：使用位操作符号*/
    public int Add2(int num1,int num2) {
        while(num2!=0){
            int temp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = temp;
        }
        return num1;
    }

    /*方法3：递归，在方法2的基础上*/
    public int Add3(int num1,int num2) {
        return num2==0?num1:Add3(num1^num2,(num1&num2)<<1);
    }
}
