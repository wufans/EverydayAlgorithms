# -*- coding: utf-8 -*-
"""
Created on Thu Sep  6 17:14:22 2018

@author: wufan
# =============================================================================
# You are a professional robber planning to rob houses along a street. Each house
 has a certain amount of money stashed, the only constraint stopping you from robbing 
 each of them is that adjacent houses have security system connected and it will 
 automatically contact the police if two adjacent houses were broken into on the same night.
# 
# Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
# 
# Example 1:
# 
# Input: [1,2,3,1]
# Output: 4
# Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
#              Total amount you can rob = 1 + 3 = 4.
# Example 2:
# 
# Input: [2,7,9,3,1]
# Output: 12
# Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
#              Total amount you can rob = 2 + 9 + 1 = 12.
# =============================================================================
"""

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #递归求解
        if len(nums) == 0:
            return 0
        elif len(nums) < 2:
            return max(nums[0], nums[-1])
        money = [0]*len(nums)
        money[0], money[1] = nums[0], max(nums[0], nums[1])
        for i in range(2, len(nums)):
            money[i] = max(nums[i] + money[i-2], money[i-1])
        return money[len(nums)-1]
    
    
# =============================================================================
#         if not nums:
#             return 0
#         if len(nums)<3:
#             return max(nums)
#         first=nums[0]
#         second=max(nums[0],nums[1])
#         s=0
#         for i in range(2,len(nums)):
#             s=max(first+nums[i],second)
#             first=second
#             second=s
#         return s
# =============================================================================
print(Solution().rob([2,7,9,3,1]))
