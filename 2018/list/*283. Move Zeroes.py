# -*- coding: utf-8 -*-
#@author: WuFan

# Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
# #
# # Example:
# #
# # Input: [0,1,0,3,12]
# # Output: [1,3,12,0,0]
# # Note:
# #
# # You must do this in-place without making a copy of the array.
# # Minimize the total number of operations.

class Solution:
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """

       
        #length = len(nums)
        # for i in range(nums.count(0)):
        #     nums.remove(0)
        # for i in range(len(nums),length):
        #     nums.append(0)
#注意这里的zero的指针
        zero = 0      # 
        for i in range(len(nums)):
            if nums[i]:
                nums[zero], nums[i] = nums[i], nums[zero]
                zero += 1
test = [0,1,0,3,12]
print(Solution().moveZeroes(test))
print(test)
