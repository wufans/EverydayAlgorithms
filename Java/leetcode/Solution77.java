/**
 * @Author: WuFan
 * @Date: 2019/4/13 13:28
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]*/
public class Solution77 {
    //Best solution
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n < k) return res;
        backtrack(res, n, k, 0, new ArrayList<Integer>());
        return res;
    }

    public void backtrack(List<List<Integer>> res, int num, int count, int start, ArrayList<Integer> tmplist) {
        if(count < 0) return;
        if(count == 0) {
            res.add(new ArrayList<Integer>(tmplist));
            return;
        }
        for(int i = start; i < num - count + 1; i++) { /////第一个i最多到n-k+1 try each possible number in this position 优化。
            tmplist.add(i + 1);
            backtrack(res, num, count - 1, i + 1, tmplist);
            tmplist.remove(tmplist.size() - 1);
        }
    }




    //My solution
    public static void main(String[] args) {
        System.out.println(combine(1,1));
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        boolean[] flag = new boolean[n];
        help(flag, n, k, new ArrayList<>(),0);
        return res;
    }

    private static void help(boolean[] flag, int n, int k, List temp, int tempindex) {
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(tempindex >= n){
            return;
        }
        for (int i = tempindex+1; i <= n; i++) {
            if(flag[i-1] == false){
                temp.add(i);
                flag[i-1] = true;
                help(flag,n,k,temp,i);
                temp.remove(temp.size()-1);
                flag[i-1] = false;
            }
        }
    }

}
