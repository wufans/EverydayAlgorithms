# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
"""


class Solution:
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        #比较重要的是需要排序，经过排序后的复杂度会比较小。o(n^2)
        minval = 100000
        result = 0
        nums.sort()
        for i in range(len(nums)):
            left = i + 1
            right = len(nums) - 1
            while left < right:
                val = nums[i] + nums[left] + nums[right]

                if abs(val - target) < minval:
                    minval = abs(val - target)
                    result = val
                if val == target:
                    return target
                if val <= target:
                    left += 1
                else:
                    right -= 1
        return result
        # minval = 100000
        # result = 0
        # nums.sort()
        # for i in range(len(nums)):
        #     left = i + 1
        #     right = len(nums) - 1
        #     while left < right:
        #         val = nums[i] + nums[left] + nums[right]
        #
        #         if abs(val - target) < minval:
        #             minval = abs(val - target)
        #             result = val
        #         if val == target:
        #             return target
        #         if val <= target:
        #             left += 1
        #         else:
        #             right -= 1
        # return result
