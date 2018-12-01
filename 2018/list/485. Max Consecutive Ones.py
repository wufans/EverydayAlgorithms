# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
"""


class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
       # 71%
        # res = 0
        # count = 0
        # for i in nums:
        #     if i == 1:
        #         count += 1
        #     else:
        #         #print(count)
        #         res = max(res, count)
        #         count = 0
        # res = max(res, count)
        # return res

        if nums[-1] != 0:
            nums.append(0)

        counter = 0
        amountOnes = []

        for i in nums:
            if i == 1:
                counter += 1
            elif i == 0 and counter > 0:
                amountOnes.append(counter)
                counter = 0

        if not amountOnes:
            return 0
        else:
            return max(amountOnes)


print(Solution().findMaxConsecutiveOnes([1,1,0,1,1,1]))
