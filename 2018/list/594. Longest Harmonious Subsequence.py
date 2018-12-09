# -*- coding: utf-8 -*-
#@author: WuFan
"""
We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
Note: The length of the input array will not exceed 20,000.
"""


class Solution(object):
    def findLHS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #题读错了

        # res = 0
        # start = 0
        # end = 0
        # nums.sort()
        # print(nums)
        # while end < len(nums):
        #     if nums[end] - nums[start] <= 1:
        #         end += 1
        #     elif nums[end] - nums[start] > 1:
        #         res = max(res,end-start)
        #         start += 1
        # return max(res,end-start)


        #10%
        # res = 0
        # start = 0
        # end = 0
        # nums.sort()
        # print(nums)
        # while end < len(nums):
        #     if nums[end] == nums[start]:
        #         end += 1
        #     elif nums[end] - nums[start] == 1:
        #         end += 1
        #         res = max(res,end-start)
        #     elif nums[end] - nums[start] > 1:
        #         #res = max(res,end-start)
        #         start += 1
        # return res

        dic = {}
        for x in nums:
            if x in dic:
                dic[x] += 1
            else:
                dic[x] = 1
        res = 0
        for x in dic:
            if x + 1 in dic:
                res = max(res, dic[x] + dic[x + 1])
        return res


print(Solution().findLHS([1,3,2,2,5,2,3,7]))
