# -*- coding: utf-8 -*-
#@author: WuFan
"""
In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input:
nums =
[[1,2],
 [3,4]]
r = 1, c = 4
Output:
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
Example 2:
Input:
nums =
[[1,2],
 [3,4]]
r = 2, c = 4
Output:
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
"""


class Solution(object):
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        #90%
        if not nums:
            return nums
        leng1 = len(nums)
        leng2 = len(nums[0])
        if r*c != leng1*leng2:
            return nums
        leng1_tmp = 0
        leng2_tmp = 0
        res = []
        for i in range(r):
            res_tmp = []
            for j in range(c):
                if leng2_tmp< leng2:
                    res_tmp.append(nums[leng1_tmp][leng2_tmp])
                elif leng2_tmp == leng2:
                    leng2_tmp = 0
                    leng1_tmp += 1
                    res_tmp.append(nums[leng1_tmp][leng2_tmp])
                leng2_tmp += 1
            res.append(res_tmp)
        return res
        # nRows = len(nums)
        # nCols = len(nums[0])
        #
        # if r * c != nRows * nCols:
        #     return nums
        #
        # numsFlat = [e for row in nums for e in row]
        # result = []
        #
        # for i in range(r):
        #     result.append(numsFlat[i * c:i * c + c])
        #
        # return result
print(Solution().matrixReshape([[1,2],
 [3,4]],
r = 1, c = 4))
