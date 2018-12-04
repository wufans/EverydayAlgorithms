# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).


Note: There are at least two nodes in this BST.
"""


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def getMinimumDifference(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        res = []
        node = [root]

        for x in node:
            res.append(x.val)
            if x.left != None:
                node.append(x.left)
            if x.right != None:
                node.append(x.right)
        res.sort()
        return min([res[i] - res[i - 1] for i in range(1, len(res))])


        # N = []
        # def dfs(root):
        #     if root.left: dfs(root.left)
        #     N.append(root.val)
        #     if root.right: dfs(root.right)
        #
        # dfs(root)
        #
        # min_val = float('inf')
        #
        # for i, v in enumerate(N[1:]):
        #     diff = abs(v - N[i])
        #
        #     if diff < min_val:
        #         min_val = diff
        #
        # return min_val
