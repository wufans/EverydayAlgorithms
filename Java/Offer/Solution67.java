/**
 * @Author: WuFan
 * @Date: 2019/3/21 15:10
 */

package offer;
/*
* 把字符串转换成整数
* 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。*/
public class Solution67 {
    //Solution1
    public static int StrToInt(String str) {
        char[] ch = str.toCharArray();
        if(ch.length<=0)
            return 0;
        int res = 0;
        for (int i = ch.length-1; i >0 ; i--) {
            if(ch[i]>'9' || ch[i]<'0'){
                return 0;
            }
            res += (ch[i]-'0')*(int)Math.pow(10,ch.length-1-i);
        }
        if(ch[0]=='+'){
            return res;
        }else if(ch[0] == '-'){
            return -res;
        }else
            return res+(ch[0]-'0')*(int)Math.pow(10,ch.length-1);
    }
    //Solution2
    public int StrToInt2(String str) {
        if (str == null || str.length() == 0)
            return 0;
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) /* 符号判定 */
                continue;
            if (c < '0' || c > '9') /* 非法输入 */
                return 0;
            ret = ret * 10 + (c - '0');
        }
        return isNegative ? -ret : ret;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt(""));
    }
}
