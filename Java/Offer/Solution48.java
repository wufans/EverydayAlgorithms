/**
 * @Author: WuFan
 * @Date: 2019/3/15 20:53
 */

package offer;



/*
* 最长不含重复字符的子字符串
* 输入一个字符串（ 只包含 a~z 的字符） ，求其最长不含重复字符的子字符串的长
度。例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。*/
public class Solution48 {
    public static int longestSubStringWithoutDuplication(String str) {
        int i = 0, j = 0;
        int res = 0;
        int[] temp = new int[26];
        char[] cha = str.toCharArray();

        while(j<cha.length){
            if(temp[cha[j]-'a']==0){
                temp[cha[j]-'a'] = 1;

                System.out.println(i+" "+j);
                j++;
                res = res>j-i?res:j-i;

            }else{
                while(i<=j && cha[i] != cha[j]){
                    temp[cha[i]-'a'] = 0;
                    i++;
                }
                i++;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestSubStringWithoutDuplication("arabcacfr"));
    }
}
