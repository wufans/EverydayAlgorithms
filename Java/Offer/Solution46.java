/**
 * @Author: WuFan
 * @Date: 2019/3/15 20:03
 */

package offer;


/*
* 把数字翻译成字符串
* 给定一个数字，按照如下规则翻译成字符串：0 翻译成“a”，1 翻译成“b”... 25 翻译
成“z”。一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 bccfi，bwfi，
bczi，mcfi，mzi。实现一个函数，用来计算一个数字有多少种不同的翻译方法。*/
public class Solution46 {
    public static int numDecodings(String s) {
        if(s.length()<=1){
            return s.length();
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if(Integer.valueOf(s.substring(i-1,i+1))>25) {
                dp[i] = dp[i -1];
            }else{
                if(i>=2)
                    dp[i] = dp[i-1]+dp[i-2];
                else
                    dp[i] = dp[i-1]+1;
            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12258"));
    }
}
