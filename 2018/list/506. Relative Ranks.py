# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.
"""


class Solution(object):
    def findRelativeRanks(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]

        """
        sort = sorted(nums)[::-1]
        rank = ["Gold Medal", "Silver Medal", "Bronze Medal"] + map(str, range(4, len(nums) + 1))
        return map(dict(zip(sort, rank)).get, nums)

        # c = nums[0:]
        # c.sort(reverse=True)
        # dic = {}
        # ans = []
        # for i in range(len(nums)):
        #     dic[c[i]] = i + 1
        #     if i < 3:
        #         if i == 0:
        #             dic[c[i]] = "Gold Medal"
        #         if i == 1:
        #             dic[c[i]] = "Silver Medal"
        #         if i == 2:
        #             dic[c[i]] = "Bronze Medal"
        # for each in nums:
        #     ans.append(str(dic[each]))
        # return ans

print(Solution().findRelativeRanks([5,4,3,2,1]))
