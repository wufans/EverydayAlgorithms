/**
 * @Author: WuFan
 * @Date: 2019/3/7 11:56
 */

package offer;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 字符串的排列
*
* 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。*/
public class Solution38 {
    private static ArrayList<String> res = new ArrayList<>();
    public static ArrayList<String> Permutation(String str) {
        if(str.length() < 1){
            return res;
        }
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        helper(ch,new boolean[ch.length],new StringBuilder());

        return res;
    }

    private static void helper(char[] toCharArray, boolean[] booleans,StringBuilder temp) {
        if(temp.length() == toCharArray.length){
            res.add(temp.toString());
            //System.out.println(res);
            return;
        }


        for (int i = 0; i < toCharArray.length; i++) {
            if(booleans[i] == true)
                continue;
            if(i>0 && toCharArray[i] == toCharArray[i-1] && booleans[i-1] == false)
                continue;
            if(booleans[i] == false) {
                temp.append(toCharArray[i]);
                booleans[i] = true;
                helper(toCharArray, booleans, temp);
                booleans[i] = false;
                temp.deleteCharAt(temp.length()-1);
            }

        }
    }

    public static void main(String[] args) {
        Permutation("aa");
    }

    private ArrayList<String> ret = new ArrayList<>();
    public ArrayList<String> Permutation2(String str) {
        if (str.length() == 0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }
    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i])
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1
                    ]) /* 保证不重复 */
                continue;
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }
}
