# -*- coding: utf-8 -*-
"""
Created on Sun Sep  2 14:40:37 2018

@author: wufan

# =============================================================================
# Given a non-empty array of integers, every element appears twice except for one. Find that single one.
# 
# Note:
# 
# Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
# 
# Example 1:
# 
# Input: [2,2,1]
# Output: 1
# Example 2:
# 
# Input: [4,1,2,1,2]
# Output: 4
# =============================================================================
"""

class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        print(nums)
        for i in range(1,len(nums),2):
            if nums[i-1]!=nums[i]:
                return nums[i-1]
        return nums[-1]
# =============================================================================
        # good sulution
#     return(sum(set(nums)) * 2  - sum(nums))
# =============================================================================
print(Solution().singleNumber([2,2,1]))
