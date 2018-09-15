# -*- coding: utf-8 -*-
"""
Created on Sat Sep 15 20:28:27 2018

@author: wufan
# =============================================================================
# Given an array of integers and an integer k, find out whether there are two 
distinct indices i and j in the array such that nums[i] = nums[j] and the absolute 
difference between i and j is at most k.
# 
# Example 1:
# 
# Input: nums = [1,2,3,1], k = 3
# Output: true
# Example 2:
# 
# Input: nums = [1,0,1,1], k = 1
# Output: true
# Example 3:
# 
# Input: nums = [1,2,3,1,2,3], k = 2
# Output: false
注意的是相邻的两个相等元素，至多不超过1
# =============================================================================
"""

class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
#        if len(nums) <= len(set(nums)):
#            return False
#
#        for i,num in enumerate(nums[:len(nums)-k]):
#            for j,num2 in enumerate(nums[i+k::-1]):
#                print(i,num,j,num2)
#                if num == num2 and j-i>=0:
#                    return False
#        return True
#        for i,num in enumerate(nums[:len(nums)-k]):
#            for j,num2 in enumerate(nums[i+k:]):
#                print(i,num,j,num2)
#                if num == num2 and j-i >=0:
#                    return True
#        return False
        
# =============================================================================
# =============================================================================
#         if len(nums) <= len(set(nums)):
#              return False
#         for i,num in enumerate(nums[:len(nums)-k]):
#              for num2 in nums[i+k+1:]:
#                  print(i,num,num2)
#                  if num == num2:
#                      return False
#         return True
# =============================================================================
        
# =============================================================================
# =============================================================================
        #right answer
        dic = {}
        for i, v in enumerate(nums):
            print(i,v)
            if v in dic and i - dic[v] <= k:
                return True
            dic[v] = i
            print(dic)
        return False
# =============================================================================

print(Solution().containsNearbyDuplicate([1,2,3,1],3))
print(Solution().containsNearbyDuplicate([1,0,1,1],1))
print(Solution().containsNearbyDuplicate([1,2,3,1,2,3],2))
                
