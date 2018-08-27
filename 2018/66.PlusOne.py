# -*- coding: utf-8 -*-
"""
Created on Sun Aug 26 22:33:01 2018

@author: wufan

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
"""

class Solution:
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        for i in range(-1,-len(digits)-1,-1):
            if digits[i] != 9:
                digits[i] += 1
                break
            else:
                digits[i] = 0
                if i == -len(digits):
                    #digits[i] = 0
                    digits.insert(0,1)
            #print(i)
        return digits
# =============================================================================
#     def plusOne(digits):
    #     num = 0
    #     for i in range(len(digits)):
    #     	num += digits[i] * pow(10, (len(digits)-1-i))
    #     return [int(i) for i in str(num+1)]
# =============================================================================
print(Solution().plusOne([9]))
