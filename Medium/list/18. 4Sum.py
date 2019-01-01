# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
"""


class Solution:
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """

#time exceed
        # nums.sort()
        # res = []
        # for i in range(len(nums)-3):
        #     for j in range(i+1,len(nums)-2):
        #         for k in range(j+1,len(nums)-1):
        #             for m in range(k+1,len(nums)):
        #                 list_tmp = [nums[i],nums[j],nums[k],nums[m]]
        #                 if sum(list_tmp)== target and not list_tmp in res:
        #                     res.append(list_tmp)
        # return res


#70%思想：利用dict的key存储两两元素之和，最后配对找到target
        # numLen, res, dict = len(num), set(), {}
        # if numLen < 4: return []
        # num.sort()
        # for p in range(numLen):
        #     for q in range(p + 1, numLen):
        #         if num[p] + num[q] not in dict:
        #             dict[num[p] + num[q]] = [(p, q)]
        #         else:
        #             dict[num[p] + num[q]].append((p, q))
        # for i in range(numLen):
        #     for j in range(i + 1, numLen - 2):
        #         T = target - num[i] - num[j]
        #         if T in dict:
        #             for k in dict[T]:
        #                 if k[0] > j:
        #                     res.add((num[i], num[j], num[k[0]], num[k[1]]))
        # return [list(i) for i in res]

#100%
        nums.sort()
        results = []
        self.findNsum(nums, target, 4, [], results)
        return results

    def findNsum(self, nums, target, N, result, results):
        if len(nums) < N or N < 2: return

        # solve 2-sum
        if N == 2:
            l, r = 0, len(nums) - 1
            while l < r:
                if nums[l] + nums[r] == target:
                    results.append(result + [nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1
                    while r > l and nums[r] == nums[r + 1]:
                        r -= 1
                elif nums[l] + nums[r] < target:
                    l += 1
                else:
                    r -= 1
        else:
            for i in range(0, len(nums) - N + 1):  # careful about range
                if target < nums[i] * N or target > nums[-1] * N:  # take advantages of sorted list
                    break
                if i == 0 or i > 0 and nums[i - 1] != nums[i]:  # recursively reduce N
                    self.findNsum(nums[i + 1:], target - nums[i], N - 1, result + [nums[i]], results)
        return


print(Solution().fourSum([1, 0, -1, 0, -2, 2],0))
