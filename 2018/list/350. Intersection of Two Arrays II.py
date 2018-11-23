# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
"""


class Solution:
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        result = []
        nums1.sort()
        nums2.sort()
        len1 = len(nums1)
        len2 = len(nums2)
        h1, h2 = 0, 0
        while h1 < len1 and h2 < len2:
            value1, value2 = nums1[h1], nums2[h2]
            if value1 == value2:
                result.append(value1)
                h1 += 1
                h2 += 1
            elif value1 < value2:
                h1 += 1
            else:
                h2 += 1
        return result


#         result = []
#         nums1_dict = {}
#         nums2_dict = {}
#         for i in nums1:
#             try:
#                 nums1_dict[i] += 1
#             except:
#                 nums1_dict[i] = 1
#         for j in nums2:
#             try:
#                 nums2_dict[j] += 1
#             except:
#                 nums2_dict[j] = 1

#         for k in nums1_dict:
#             if k in nums2_dict:
#                 counter = max(nums2_dict[k], nums1_dict[k]) - abs(nums2_dict[k]-nums1_dict[k])
#                 while counter > 0:
#                     counter-=1
#                     result.append(k)
#         return result


# a, b = map(collections.Counter, (nums1, nums2))
# return list((a & b).elements())
print(Solution().intersect([4,9,5,9], [9,4,9,8,4]))
