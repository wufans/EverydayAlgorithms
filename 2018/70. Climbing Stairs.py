# -*- coding: utf-8 -*-
"""
Created on Mon Aug 27 20:35:03 2018

@author: wufan
# =============================================================================
# You are climbing a stair case. It takes n steps to reach to the top.
# 
# Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
# 
# Note: Given n will be a positive integer.
# 
# Example 1:
# 
# Input: 2
# Output: 2
# Explanation: There are two ways to climb to the top.
# 1. 1 step + 1 step
# 2. 2 steps
# Example 2:
# 
# Input: 3
# Output: 3
# Explanation: There are three ways to climb to the top.
# 1. 1 step + 1 step + 1 step
# 2. 1 step + 2 steps
# 3. 2 steps + 1 step
# =============================================================================
题目是一个动态规划问题。动态规划主要是找到从大问题化解为多个小问题的方案，通过解决这些小问题并进行组合得到大问题的结果。从大到小进行分析，发现如果要到达台阶n，可以从台阶n-1到达，也可以从台阶n-2到达，那么只需要得到到达台阶n-1有多少种方案和到达台阶n-2有多少种方案，二者相加即可得到到达台阶n有多少种方案。递推公式如下： 
climb(m) = 0, m < 0 
climb(0) = 1 
climb(1) = 1 
climb(n) = climb(n-1)+climb(n-2), n >= 2 
得到了递推公式，就可以用递归的方式求解问题。动态规划一般情况下有一个可优化的点，即在递归的基础上增加一个保存中间结果的缓存，将中间结果缓存下来。比如本题中，当n=5时，我们需要计算climb(4)和climb(3)，但当计算climb(4)时又需要计算climb(3)和climb(2)，可以看到上述过程中将climb(3)重复计算了两次，增加了递归次数和时间上的开销，于是我们可以用一个缓存，当第一次计算climb(3)时将其结果记录下来，之后再计算时，查看是否已经计算过，如果计算过直接将该值返回即可，避免了重复的计算。
"""

class Solution:
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        a = b = 1
        for _ in range(n):
            a, b = b, a + b
        return a
print(Solution().climbStairs(5))
