# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
Note:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
"""


class Solution(object):
    def findShortestSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        import collections
        first, last = {}, {}
        for i, v in enumerate(nums):
            first.setdefault(v, i)
            last[v] = i
        c = collections.Counter(nums)
        degree = max(c.values())
        return min(last[v] - first[v] + 1 for v in c if c[v] == degree)

        # d = {}
        # l = len(nums)
        # rev = nums[::-1]
        # for n in nums:
        #     d[n] = 1 if n not in d else d[n] + 1
        #
        # m = max(d.values())
        # if m == 1:
        #     return 1
        #
        # keys = [k for k in d if d[k] == m]
        # result = float('inf')
        # for k in keys:
        #     start = nums.index(k)
        #     end = l - 1 - rev.index(k)
        #     result = min(result, end - start + 1)
        # return result
