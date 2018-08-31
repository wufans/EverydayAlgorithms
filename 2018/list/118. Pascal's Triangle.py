# -*- coding: utf-8 -*-
"""
Created on Fri Aug 31 11:11:02 2018

@author: wufan
# =============================================================================
# Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
# 
# 
# In Pascal's triangle, each number is the sum of the two numbers directly above it.
# 
# Example:
# 
# Input: 5
# Output:
# [
#      [1],
#     [1,1],
#    [1,2,1],
#   [1,3,3,1],
#  [1,4,6,4,1]
# ]
# =============================================================================
"""
class Solution:
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
# =============================================================================
#         def getone(numRow):
#             if numRow == 1:
#                 return [1]
#             elif numRow == 2:
#                 return [1,1]
#             else:
#                 result = [1,1]
#                 for x in range(1,numRow-1):#self.generate(numRows):
#                     #self.generate(numRows-1).insert()
#                     result.insert(x,getone(numRow-1)[x-1]+getone(numRow-1)[x])
#                 return result
#         re = []
#         for i in range(1,numRows+1):
#             re.append(getone(i))
#         return re
# =============================================================================
# =============================================================================
#         res = [[1]]
#         for i in range(1, numRows):
#             res += [list(map(lambda x, y: x+y, res[-1] + [0], [0] + res[-1]))]
#             #res += (res[-1]+[0])
#         return res[:numRows]
# =============================================================================
    #fastest
        if numRows == 0:
            return []
        else:
            ans = [[1]]
        for i in range(1, numRows):
            row = [1]
            for j in range(i-1):
                row.append(ans[i-1][j] + ans[i-1][j+1])
            row.append(1)
            ans.append(row)
        return ans
print(Solution().generate(5))
