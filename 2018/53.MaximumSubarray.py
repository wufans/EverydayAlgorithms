# -*- coding: utf-8 -*-
"""
Created on Sun Aug 26 21:00:58 2018

@author: wufan

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

"""

class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
# Time Limit Exceeded method - my wrong method
# =============================================================================
#         if not nums: return 0
#         max_num = max(nums)
#         for n in range(2,len(nums)+1):
#             tmp = 0
#             for i in range(len(nums)-n+1):
#                 for x in range(n):
#                     tmp += nums[i+x]
#                     
#                 if tmp > max_num:
#                     #print(n,i)
#                     max_num = tmp 
#                 tmp = 0
#         return max_num
# print(Solution().maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))
# =============================================================================
#        这是一道非常经典的动态规划的题目，用到的思路我们在别的动态规划题目中也很常用，以后我们称为”局部最优和全局最优解法“。
#基本思路是这样的，在每一步，我们维护两个变量，一个是全局最优，就是到当前元素为止最优的解是，一个是局部最优，就是必须包含当前
#元素的最优的解。接下来说说动态规划的递推式（这是动态规划最重要的步骤，递归式出来了，基本上代码框架也就出来了）。假设我们已知
#第i步的global[i]（全局最优）和local[i]（局部最优），那么第i+1步的表达式是：
#local[i+1]=Math.max(A[i], local[i]+A[i])，就是局部最优是一定要包含当前元素，所以不然就是上一步的局部最优local[i]+
#当前元素A[i]（因为local[i]一定包含第i个元素，所以不违反条件），但是如果local[i]是负的，那么加上他就不如不需要的，所以不
#然就是直接用A[i]；
#global[i+1]=Math(local[i+1],global[i])，有了当前一步的局部最优，那么全局最优就是当前的局部最优或者还是原来的全局最优
#（所有情况都会被涵盖进来，因为最优的解如果不包含当前元素，那么前面会被维护在全局最优里面，如果包含当前元素，那么就是这个局部最优）。
#
#接下来我们分析一下复杂度，时间上只需要扫描一次数组，所以时间复杂度是O(n)。空间上我们可以看出表达式中只需要用到上一步local[i]
#和global[i]就可以得到下一步的结果，所以我们在实现中可以用一个变量来迭代这个结果，不需要是一个数组，也就是如程序中实现的那样，
#所以空间复杂度是两个变量（local和global），即O(2)=O(1)。
        l = g = -1000000000
        for n in nums:
            l = max(n,l+n)
            g = max(l,g)
        return g
