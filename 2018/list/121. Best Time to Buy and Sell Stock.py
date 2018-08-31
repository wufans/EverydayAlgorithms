# -*- coding: utf-8 -*-
"""
Created on Fri Aug 31 15:07:13 2018

@author: wufan
# =============================================================================
# Say you have an array for which the ith element is the price of a given stock on day i.
# 
# If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
# 
# Note that you cannot sell a stock before you buy one.
# 
# Example 1:
# 
# Input: [7,1,5,3,6,4]
# Output: 5
# Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
#              Not 7-1 = 6, as selling price needs to be larger than buying price.
# Example 2:
# 
# Input: [7,6,4,3,1]
# Output: 0
# Explanation: In this case, no transaction is done, i.e. max profit = 0.
# =============================================================================
"""

class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
# =============================================================================
        #遍历法(超时)
#         maxn = 0
#         for _ in range(1,len(prices)):
#             maxn = max(maxn, max(prices[_:])-min(prices[:_]))
#         return maxn
# =============================================================================
        
# =============================================================================
#         my final solution
#         if not prices:return 0
#         min_n = prices[0]
#         max_result = 0
#         for _ in prices[1:]:
#             max_result ,min_n = max( _ - min_n,max_result),min(_,min_n)
#         return max_result
# =============================================================================
    
        if len(prices) < 2:
            return 0
        min_price = prices[0]
        max_profit = 0
        for price in prices:
            if price < min_price:
                min_price = price
            if price - min_price > max_profit:
                max_profit = price - min_price
        return max_profit

print(Solution().maxProfit([7,1,5,3,6,4]))
print(Solution().maxProfit([7,6,4,3,1]))
