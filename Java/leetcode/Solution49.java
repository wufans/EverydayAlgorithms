/**
 * @Author: WuFan
 * @Date: 2019/3/31 10:41
 */

package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/*
* Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/
public class Solution49 {
    //MySolution
    public List<List<String>> groupAnagrams1(String[] strs) {
        if(strs==null || strs.length == 0){
            return null;
        }
        Map<String,List<String>> temp = new HashMap<>();
        for(String str: strs){
            char[] cha = str.toCharArray();
            Arrays.sort(cha);
            String s = String.valueOf(cha);
            if(temp.containsKey(s)){
                temp.get(s).add(str);
            }else {
                temp.put(s, new ArrayList<>());
                temp.get(s).add(str);
            }
        }
        return new ArrayList<>(temp.values());
    }

    //Solution2
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> ret = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String encoded = encode(str);
            if (map.containsKey(encoded))
                map.get(encoded).add(str);
            else {
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(encoded, list);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet())
            ret.add(entry.getValue());

        return ret;
    }
    //类似hash编码，降低比较的复杂度
    private String encode(String str) {
        int[] freq = new int[26];
        String spliter = "-";
        for (int i = 0; i < str.length(); i++)
            freq[str.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freq.length; i++)
            sb.append(freq[i]).append(spliter);
        return sb.toString();
    }


    //一行代码。。。牛逼了
    public List<List<String>> groupAnagrams3(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(
                str ->str.chars().sorted().collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append).toString())).values());
    }
}
