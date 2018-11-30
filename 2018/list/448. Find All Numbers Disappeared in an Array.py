# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
"""


class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        #sorted(nums)

        #time exceed
        # if not nums:return []
        # count = 0
        # res = []
        # for i in range(1,len(nums)+1):
        #     if not i in nums:
        #         res.append(i)
        # return res

        #对于每个数字nums[i]，如果其对应的nums[nums[i] - 1]
        #是正数，我们就赋值为其相反数，如果已经是负数了，就不变了，那么最后我们只要把留下的整数对应的位置加入结果res中即可

        #以下两个方法的共同点是根据值标记出已经出现的数值

        # for i in range(len(nums)):
        #     index = abs(nums[i]) - 1
        #     nums[index] = - abs(nums[index])
        # #print(nums)
        # return [i + 1 for i in range(len(nums)) if nums[i] > 0]

        # for v in nums:
        #     index = int(v) - 1
        #     nums[index] += 0.4
        # return [i + 1 for i in range(len(nums)) if nums[i] == int(nums[i])]

        #one-line solution
        #return list(set(range(1, len(nums) + 1)).difference(set(nums)))

        for i in nums:
            index = abs(i) -1
            nums[index] = -abs(nums[index])
            print(nums)
        return [i + 1 for i in range(len(nums)) if nums[i] > 0]


print(Solution().findDisappearedNumbers([4,3,2,7,8,2,3,1]))
