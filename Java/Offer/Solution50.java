/**
 * @Author: WuFan
 * @Date: 2019/3/16 16:36
 */

package offer;

import java.util.BitSet;

/*
* 第一个只出现一次的字符位置
* 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.*/
public class Solution50 {
    public int FirstNotRepeatingChar(String str) {
        if(str.length()==0){
            return -1;
        }

        int[] temp = new int[52];
        char[] cha = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            if(cha[i]<='z' && cha[i]>='a'){
                temp[cha[i]-'a']++;
            }
            if(cha[i]<='Z' && cha[i]>='A'){
                temp[cha[i]-'A'+26]++;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if(cha[i]<='z' && cha[i]>='a'){
                if(temp[cha[i]-'a']==1){
                    return i;
                }
            }
            if(cha[i]<='Z' && cha[i]>='A'){
                if(temp[cha[i]-'A'+26]==1){
                    return i;
                }
            }
        }

        return -1;

//        //空间复杂度优化,利用两个BitSet存储会更加节省空间
//        BitSet bs1 = new BitSet(256);
//        BitSet bs2 = new BitSet(256);
//        for (char c : str.toCharArray()) {
//            if (!bs1.get(c) && !bs2.get(c))
//                bs1.set(c); // 0 0 -> 0 1
//            else if (bs1.get(c) && !bs2.get(c))
//                bs2.set(c); // 0 1 -> 1 1
//        }
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (bs1.get(c) && !bs2.get(c)) // 0 1
//                return i;
//        }
//        return -1;
    }
}
