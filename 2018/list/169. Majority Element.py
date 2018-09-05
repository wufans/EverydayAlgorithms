# -*- coding: utf-8 -*-
"""
Created on Wed Sep  5 14:16:03 2018

@author: wufan
# =============================================================================
# Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
# 
# You may assume that the array is non-empty and the majority element always exist in the array.
# 
# Example 1:
# 
# Input: [3,2,3]
# Output: 3
# Example 2:
# 
# Input: [2,2,1,1,1,2,2]
# Output: 2
# =============================================================================
"""

class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:return None
        dic = {}
        result = nums[0]
        max_times = 0
        for i in nums:
            if i in dic:
                dic[i] += 1
                if dic[i] > max_times:
                    max_times = dic[i]
                    result = i
            else:
                dic[i] = 1
                if dic[i] > max_times:
                    max_times = dic[i]
                    result = i
        print(dic,result,max_times)
        return result if max_times > len(nums)/2 else None
print(Solution().majorityElement([1]))

# =============================================================================
# fastest solution
#         nums.sort()
#         return nums[len(nums)//2]
# =============================================================================
