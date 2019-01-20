/**
 * @Author: WuFan
 * @Date: 2019/1/20 23:54
 */

package leetcode;
/*
* Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (candidates == null) return res;
//        Arrays.sort(candidates);
//        getCombinations(res, new ArrayList<>(), candidates, target, 0);
//        return res;
//    }
//
//    private void getCombinations(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int pos) {
//        if (target < 0) return;
//        if (target == 0) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = pos; i < nums.length; i++) {
//            if (nums[i] > target) break;
//            if (i > pos && nums[i] == nums[i - 1]) continue;
//            list.add(nums[i]);
//            getCombinations(res, list, nums, target - nums[i], i);
//            list.remove(list.size() - 1);
//        }
//  }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null) return res;
        Arrays.sort(candidates);
        getCombinations(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void getCombinations(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int pos) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] > target) break;
            if (i > pos && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            getCombinations(res, list, nums, target - nums[i], i);
            list.remove(list.size() - 1);
        }
    }

}

