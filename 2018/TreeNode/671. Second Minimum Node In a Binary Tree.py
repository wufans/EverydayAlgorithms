# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input:
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input:
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
"""


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findSecondMinimumValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """


        # res = [float('inf')]
        #
        # def traverse(node):
        #     if not node:
        #         return
        #     if root.val < node.val < res[0]:
        #         res[0] = node.val
        #     traverse(node.left)
        #     traverse(node.right)
        #
        # traverse(root)
        # return -1 if res[0] == float('inf') else res[0]

        # self.list = [root.val]
        #
        # def cursor(root):
        #     if root:
        #         if root.val not in self.list:
        #             if len(self.list) == 1:
        #                 self.list.append(root.val)
        #             else:
        #                 if root.val < self.list[1] and root.val > self.list[0]:
        #                     self.list[1] = root.val
        #         cursor(root.left)
        #         cursor(root.right)
        #
        # cursor(root)
        #return self.list[1] if len(self.list) > 1 else -1
