# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
"""


class Solution(object):
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #90
        sort_nums = sorted(nums)
        res = len(nums)
        for i in range(len(nums)):
            if nums[i] == sort_nums[i]:
                res -= 1
            else:
                break
        if res != 0:
            for i in range(-1,-len(nums)-1,-1):
                if nums[i] == sort_nums[i]:
                    res -= 1
                else:
                    break
        return res
        # l, r = 0, len(nums) - 1
        # while (l < r and nums[l] <= nums[l + 1]):  l += 1
        # if (l >= r):  return 0;
        # while (nums[r] >= nums[r - 1]):  r -= 1
        #
        # maxval = max(nums[l:r + 1])
        # minval = min(nums[l:r + 1])
        #
        # while (l >= 0 and minval < nums[l]):  l -= 1
        # while (r < len(nums) and nums[r] < maxval):  r += 1
        #
        # return (r - l - 1)
print(Solution().findUnsortedSubarray([]))
