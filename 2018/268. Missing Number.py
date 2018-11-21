# -*- coding: utf-8 -*-
#@author: WuFan

# Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
#
# Example 1:
#
# Input: [3,0,1]
# Output: 2
# Example 2:
#
# Input: [9,6,4,2,3,5,7,0,1]
# Output: 8

class Solution:
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
# time exceeded
        # for n in range(max(nums) + 1):
        #     if not n in nums:
        #         return n
        # return len(nums)
        # test = set(nums)
        # for x in range(len(test)-1):
            #         nums.sort()

            #         # Ensure that n is at the last index
            #         if nums[-1] != len(nums):
            #             return len(nums)
            #         # Ensure that 0 is at the first index
            #         elif nums[0] != 0:
            #             return 0

            #         # If we get here, then the missing number is on the range (0, n)
            #         for i in range(1, len(nums)):
            #             expected_num = nums[i-1] + 1
            #             if nums[i] != expected_num:
            #                 return expected_num
        expected_sum = sum(range(1, len(nums) + 1))
        actual_sum = sum(nums)

        return expected_sum - actual_sum
#         asum=sum(nums)
#         return len(nums)*(len(nums)+1)//2 - asum
print(Solution().missingNumber([9,6,4,2,3,5,7,0,1]))
