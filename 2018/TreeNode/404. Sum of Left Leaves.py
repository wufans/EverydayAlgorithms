# -*- coding: utf-8 -*-
#@author: WuFan

"""
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
"""


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return 0
        node = [root]
        result = 0
        for x in node:
            if x.left != None and x.left.left == None and x.left.right == None:
                result = result + x.left.val
            elif x.left != None:
                node.append(x.left)
            if x.right != None:
                node.append(x.right)
        return result

        # if not root:
        #     return 0
        # s = 0
        # q = [root]
        # while q:
        #     node = q.pop(0)
        #     if node.left:
        #         q.append(node.left)
        #         if not node.left.left and not node.left.right:
        #             s += node.left.val
        #     if node.right:
        #         q.append(node.right)
        #
        # return s
