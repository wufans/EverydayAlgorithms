# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
"""


class Solution:
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        # faster than 23%
        # nums1 = set(nums1)
        # nums2 = set(nums2)
        # result = []
        # if len(nums1) < len(nums2):
        #     for x in nums1:
        #         if x in nums2:
        #             result.append(x)
        # else:
        #     for x in nums2:
        #         if x in nums1:
        #             result.append(x)
        # return result

        # one -line solution
        return list(set(nums1) & set(nums2))

print(Solution().intersection([4,9,5], [9,4,9,8,4]))
