# -*- coding: utf-8 -*-
"""
Created on Sun Aug 19 21:18:36 2018

@author: wufan

Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
"""

class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i, num in enumerate(nums):
            sub_num = target - num
            if sub_num in nums:
                t_index = nums.index(sub_num)
                if t_index != i:
                    return [i, t_index]

test =  Solution()
result = test.twoSum([1,2,3],1)
print(result)