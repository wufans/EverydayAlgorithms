# -*- coding: utf-8 -*-
"""
Created on Sat Sep 15 20:19:58 2018

@author: wufan
# =============================================================================
# Given an array of integers, find if the array contains any duplicates.
# 
# Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
# 
# Example 1:
# 
# Input: [1,2,3,1]
# Output: true
# Example 2:
# 
# Input: [1,2,3,4]
# Output: false
# Example 3:
# 
# Input: [1,1,1,3,3,4,3,2,4,2]
# Output: true
# =============================================================================
"""
class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        return len(nums) != len(set(nums))
print(Solution().containsDuplicate([1,1,1,3,3,4,3,2,4,2]))
print(Solution().containsDuplicate([]))
