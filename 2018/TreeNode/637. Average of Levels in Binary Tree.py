# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
"""


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        #98%
        nodes = [root]
        res = []
        while nodes:
            node_tmp = []
            res_tmp = 0
            count = 0
            for node in nodes:
                res_tmp += node.val
                count += 1
                if node.left:
                    node_tmp.append(node.left)
                if node.right:
                    node_tmp.append(node.right)
            nodes = node_tmp
            res.append(res_tmp//count)
        return res
