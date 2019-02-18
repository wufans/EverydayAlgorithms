package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: wufan
 * @Date: 2019/2/16 13:41
 * @Version 1.0
 */
/*

//参考https://www.cnblogs.com/grandyang/p/4359825.html  非常详细的解法！
* Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]*/
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }

    /*交换法~
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0) return res;

        Arrays.sort(nums);



        helper(res,nums,0);

        return res;
    }

    public void helper(List<List<Integer>> res, int[] nums, int m)
    {
        if(m == nums.length)
        {
            List<Integer> tempList = new ArrayList<>();
            for(int n: nums) tempList.add(n);
            res.add(new ArrayList<>(tempList));
        }

        else
        {
            Set<Integer> set = new HashSet<Integer>();
            for(int i = m; i < nums.length;i++)
            {
                if(set.add(nums[i]))
                {
                    swap(i,m,nums);
                    helper(res,nums,m+1);
                    swap(i,m,nums);
                }

            }
        }

    }

    public void swap(int i,int j,int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }*/
}
