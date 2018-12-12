# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
"""


class Solution(object):
    def largestNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        # res = ""
        # for i in range(len(nums)):
        #     for j in range(i + 1, len(nums)):
        #         if str(nums[i]) + str(nums[j]) < str(nums[j]) + str(nums[i]):
        #             nums[i], nums[j] = nums[j], nums[i]
        # res = ""
        # for x in nums:
        #     res += str(x)
        # res = res.lstrip("0")
        # return res if res != "" else "0"

        # def scmp(sa, sb):
        #
        #     if sa[0] != sb[0]:
        #         return 2 * (sa[0] > sb[0]) - 1
        #     else:
        #         sc1, sc2 = sa + sb, sb + sa
        #         if sc1 == sc2:
        #             return 0
        #         elif sc1 > sc2:
        #             return 1
        #         else:
        #             return -1
        #
        # sres = "".join(sorted([str(i) for i in nums], cmp=scmp, reverse=True))
        # if sres[0] == "0":
        #     return "0"
        # else:
        #     return sres

        # num = [str(x) for x in nums]
        # num.sort(cmp=lambda x, y: cmp(y + x, x + y))
        # return str(int(''.join(num)))
print(Solution().largestNumber([0,0]))
