package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wufan
 * @Date: 2019/1/23 17:29
 * @Version 1.0
 */

/*
* Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]*/
public class Solution40 {
//    List<List<Integer>> res=new ArrayList<List<Integer>>();
//
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        helper(candidates,0,target,new ArrayList<Integer>());
//        return res;
//    }
//
//    public void helper(int[] candidates,int start,int target,List<Integer> cur){
//        if(target==0){
//            res.add(new ArrayList<Integer>(cur));
//        }
//        for(int i=start;i<candidates.length;i++){
//            if(i>0 && i!=start && candidates[i]==candidates[i-1])
//                continue;
//            if(candidates[i]<=target){
//                cur.add(candidates[i]);
//                helper(candidates,i+1,target-candidates[i],cur);
//                cur.remove(cur.size()-1);
//            }else{
//                break;
//            }
//        }
//    }
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs_com(cand, 0, target, path, res);
        return res;
    }

    void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        if (target < 0) return;
        for (int i = cur; i < cand.length; i++) {
            if (i > cur && cand[i] == cand[i - 1]) continue;
            path.add(path.size(), cand[i]);
            dfs_com(cand, i + 1, target - cand[i], path, res);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        Solution40 test = new Solution40();
        test.combinationSum2(new int[]{10,1,2,7,6,1,5},8);

    }
}
