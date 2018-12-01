# -*- coding: utf-8 -*-
#@author: WuFan
""""""
"""
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:
思路： 
1.遍历数组，如果是1则加上4（四条边）； 
2.如果该位置是1并且它的左边是1的话，那么就抵消了两条边，则减2； 
3.如果该位置是1并且它的上边是1的话，那么就抵消了两条边，则减2； 
4.返回周长即可。

"""


class Solution(object):
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        #80.23%
        # land = 0
        # perimeter = 0
        # high = len(grid)
        # length = len(grid[0])
        #
        # for i in range(high):
        #     for j in range(length):
        #         if grid[i][j] == 1:
        #             land += 1
        #             if i-1 >= 0:
        #                 if grid[i-1][j] == 1:
        #                     perimeter += 1
        #             if i+1 < high:
        #                 if grid[i+1][j] == 1:
        #                     perimeter += 1
        #             if j - 1 >= 0:
        #                 if grid[i][j-1] == 1:
        #                     perimeter += 1
        #             if j+1 < length:
        #                 if grid[i][j+1] == 1:
        #                     perimeter += 1
        # return land*4 - perimeter

        h = len(grid)
        l = len(grid[0])

        res = 0
        for i in range(h):
            for j in range(l):
                if grid[i][j] == 1:
                    if (i == 0) or (grid[i - 1][j] == 0):
                        res += 2
                    if (j == 0) or (grid[i][j - 1] == 0):
                        res += 2
        return res
print(Solution().islandPerimeter([[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]))
