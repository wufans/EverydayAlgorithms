/**
 * @Author: WuFan
 * @Date: 2019/3/3 15:12
 */

package offer;
/*
* 表示数值的字符串
* true
"+100"
"5e2"
"-123"
"3.1416"
"-1E-16"

false
"12e"
"1a3.14"
"1.2.3"
"+-5"
"12e+4.3"*/
public class Solution20 {
    //用正则表达式
    /*
    *   [] ： 字符集合
        () ： 分组
        ? ： 重复 0 ~ 1
        + ： 重复 1 ~ n
        * ： 重复 0 ~ n
        . ： 任意字符
        \\. ： 转义后的 .
        \\d ： 数字*/
    public boolean isNumeric(char[] str) {
        if (str == null)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-] ?\\d+)?");
    }
    public boolean isNumeric2(char[] str) {
        if(str == null || str.length == 0) return false;
        //首先如果两边有空格的话需要先去掉空格
        int index = 0;
        int length = str.length;
        while(index < length && str[index] == ' ') index++;
        if(index >= length) return false;
        while(str[length - 1] == ' ') length--;
        //第一步：判断是否是一个整数
        //如果第一位是+或者-号的时候
        if(str[index] == '+' || str[index] == '-') index++;
        if(index >= length) return false;
        //如果后面是数字的话就跳过
        while(index < length && str[index] >= '0' && str[index] <= '9') index++;
        if(index == length) return true;
        int index2 = index;
        //第二步：判断是否还有小数部分
        if(str[index] == '.'){
            index++;
            if(index == length) return true;
            index2 = index;
            while(index < length && str[index] >= '0' && str[index] <= '9') index++;
            if(index == index2) return false;
            if(index == length) return true;
        }

        //第三步：判断是否有科学计数法
        if(str[index] == 'e' || str[index] == 'E'){
            index++;
            if(index == length) return false;
            if(str[index] == '+' || str[index] == '-') index++;
            index2 = index;
            while(index < length && str[index] >= '0' && str[index] <= '9') index++;
            if(index == index2) return false;
            if(index == length) return true;
        }
        return false;
    }
}
