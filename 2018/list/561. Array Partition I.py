# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
"""


class Solution(object):
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #time exceed
        #return sum([sorted(nums)[k] for k in range(0,len(nums),2)])

        #76.7%
        # nums.sort()
        # res = 0
        # for i in range(0,len(nums),2):
        #     res += nums[i]
        # return res
        #return nums
        x = sorted(nums)

        return sum(x[::2])

print(Solution().arrayPairSum([1,4,3,2]))
