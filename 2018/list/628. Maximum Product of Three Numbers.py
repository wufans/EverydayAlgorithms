# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
"""


class Solution(object):
    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
    #注意里面的值可能小于0！！！！！！！
        nums.sort()
        if nums[0] < 0 and nums[1] < 0:
            if nums[0] * nums[1] > nums[-3] * nums[-2]:
                return nums[-1] * nums[0] * nums[1]

        return nums[-1] * nums[-2] * nums[-3]
        # max1, max2, max3 = float("-inf"), float("-inf"), float("-inf")
        # min1, min2 = float("inf"), float("inf")
        # for num in nums:
        #     if num > max3:
        #         max1, max2, max3 = sorted([max1, max2, num], reverse=True)
        #     if num < min2:
        #         min1, min2 = sorted([min1, num])
        # return max1 * max(max2 * max3, min1 * min2)
print(Solution().maximumProduct([4,-3,2,1,60]))
