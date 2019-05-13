package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wufan77
 * @date 2019/5/13 15:18
 */

/*
* Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]*/
public class Solution93 {
//
    public static void main(String[] args) {
        List<String> res = restoreIpAddresses("010010");
        System.out.println(res);

    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s.toCharArray(), res,"",0,0,0);
        return res;
    }
    public static void helper(char[] chars, List<String> res, String temp, int tempInteger, int tempIndex,int dotNumber){
//        System.out.println(temp);
        if(dotNumber > 3){
            return;
        }
        if(tempInteger < 0 || tempInteger > 255){
            return;
        }
        if(tempIndex == chars.length){
            if(dotNumber == 3){
                res.add(temp);
            }
            return;
        }
        if(temp.length()!=0 && temp.charAt(temp.length()-1)!= '.'){
            helper(chars, res,temp+".",0,tempIndex,dotNumber+1);
        }

        if(temp.length()!=0 && tempInteger == 0 && temp.charAt(temp.length()-1)!= '.'){
            return;
        }
        helper(chars, res, temp + chars[tempIndex],tempInteger * 10 + (chars[tempIndex]-'0'),tempIndex+1,dotNumber);

    }
}
