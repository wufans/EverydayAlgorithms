# -*- coding: utf-8 -*-
"""
Created on Mon Dec 10 23:10:02 2018

@author: WuFan
"""
# =============================================================================
# Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
# 
# Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
# 
# Example 1:
# Input: flowerbed = [1,0,0,0,1], n = 1
# Output: True
# Example 2:
# Input: flowerbed = [1,0,0,0,1], n = 2
# Output: False
# Note:
# The input array won't violate no-adjacent-flowers rule.
# The input array size is in the range of [1, 20000].
# n is a non-negative integer which won't exceed the input array size.
# =============================================================================
class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
#        length = len(flowerbed)
#        count = 0
#        if n == 0:
#            return True
#        if length <= 2:
#            if sum(flowerbed) ==0 and n ==1:
#                return True
#            else:
#                return False
#        if sum(flowerbed[:2]) == 0:
#            flowerbed[0] == 1
#            count += 1
#            
#        for i in range(1,length-2):
#            
#            if sum(flowerbed[i:i+3]) ==0:
#                flowerbed[i+1] = 1
#                count += 1
#                #print(flowerbed)
#        if sum(flowerbed[-2:]) == 0:
#            count += 1
#        return count >= n
        cnt = 1
        rst = 0
        for i in flowerbed:
            if i == 1:
                rst += (cnt-1)/2
                cnt = 0
            else:
                cnt += 1
        
        if cnt > 1:rst += cnt/2
        
        return rst >= n
    
print(Solution().canPlaceFlowers([0,0],2))
