/**
 * @Author: WuFan
 * @Date: 2019/5/12 9:49
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]*/
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        subsets(list,tempList,nums,0);

        tempList.clear();
        list.add(tempList);

        return list;
    }

    public void subsets(List<List<Integer>> list, List<Integer> tempList, int[] nums, int index){

        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            list.add(new ArrayList<>(tempList));
            subsets(list,tempList,nums,i+1);
            //判断是否是重复的元素
            for (int j = i+1; j < nums.length; j++)
                if(nums[i] == nums[j]) i++;
                else  break;

            tempList.remove(tempList.size()-1);
        }

    }

}
