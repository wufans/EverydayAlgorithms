# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
Note: The n belongs to [1, 10,000].
"""


class Solution(object):
    def checkPossibility(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        #beats 11%
        # if len(nums) == 1:
        #     return True
        # for i in range(1,len(nums)):
        #     if nums[i]<nums[i-1]:
        #         tmp = nums[i]
        #         nums[i] = nums[i-1]
        #         if nums != sorted(nums):
        #             nums[i] = tmp
        #             nums[i-1] = tmp
        #             return nums == sorted(nums)
        # return True

        #beats 100%
        dcount = 0
        for i in range(1, len(nums)):
            if nums[i] < nums[i - 1]:
                dcount += 1
                if dcount > 1:
                    return False
                if i - 2 < 0 or nums[i] >= nums[i - 2]:
                    nums[i - 1] = nums[i]
                else:
                    nums[i] = nums[i - 1]
        return True



print(Solution().checkPossibility([3,4,2,3]))

print(Solution().checkPossibility([2,3,3,2,4]))
