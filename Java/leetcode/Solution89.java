/**
 * @Author: WuFan
 * @Date: 2019/5/5 9:40
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

Example 1:

Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

For a given n, a gray code sequence may not be uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence.

00 - 0
10 - 2
11 - 3
01 - 1
Example 2:

Input: 0
Output: [0]
Explanation: We define the gray code sequence to begin with 0.
             A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
             Therefore, for n = 0 the gray code sequence is [0].
 */
public class Solution89 {
    public static List<Integer> grayCode(int n) {
//        List<Integer> res = new ArrayList<>();
//        res.add(0);
//        int length = (int)Math.pow(2,n);
//        if(length == 0)
//            return res;
//        boolean[] flag = new boolean[length];
//        flag[0] = true;
//        int current = 0;
//
//        for (int i = 1; i < length; i++) {
//            int add = 1;
//
//            while(add <= length){
//                int index = current^add;
//                if(flag[index] == false){
//                    flag[index] = true;
//                    current = index;
//                    res.add(current);
//                    break;
//                }else{
//                    add = add<<1;
//                }
//            }
//
//        }
//        return res;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }
}
