# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
"""


class Solution(object):
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        #one-line solution but time exceeded
        # return float(max([sum(nums[t - k:t]) for t in range(k, len(nums)+1)])) / k

        summ = sum(nums[:k])
        maximum = summ
        for i in range(1, len(nums) - k + 1):
            summ -= nums[i - 1]
            summ += nums[i + k - 1]
            maximum = max(maximum, summ)
        return float(maximum) / k

        # maxSum = sum(nums[:k])
        # runningSum = maxSum
        #
        # for i in range(k, len(nums)):
        #     runningSum = runningSum + nums[i] - nums[i - k]
        #     if runningSum > maxSum:
        #         maxSum = runningSum
        # return maxSum / float(k)

print(Solution().findMaxAverage([4,0,4,3,3],5))
