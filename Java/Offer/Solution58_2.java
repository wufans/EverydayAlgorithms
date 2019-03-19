/**
 * @Author: WuFan
 * @Date: 2019/3/19 21:05
 */

package offer;
/*
* 左旋转字符串
* 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！*/
public class Solution58_2 {
    //MySolution
    public static String LeftRotateString(String str,int n) {
        if(str.length()==0){
            return "";
        }
        int left = n%(str.length());
        return str.substring(left,str.length())+str.substring(0,left);
    }
    //Solution2
    //先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转
    //得到 "XYZdefabc"。
    public String LeftRotateString2(String str, int n) {
        if (n >= str.length())
            return str;
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }
    private void reverse(char[] chars, int i, int j) {
        while (i < j)
            swap(chars, i++, j--);
    }
    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcXYZdef",3));
    }
}
