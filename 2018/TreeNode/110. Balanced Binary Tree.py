# -*- coding: utf-8 -*-
"""
Created on Fri Aug 31 09:30:36 2018

@author: wufan
# =============================================================================
# Given a binary tree, determine if it is height-balanced.
# 
# For this problem, a height-balanced binary tree is defined as:
# 
# a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
# 
# Example 1:
# 
# Given the following tree [3,9,20,null,null,15,7]:
# 
#     3
#    / \
#   9  20
#     /  \
#    15   7
# Return true.
# 
# Example 2:
# 
# Given the following tree [1,2,2,3,3,null,null,4,4]:
# 
#        1
#       / \
#      2   2
#     / \
#    3   3
#   / \
#  4   4
# Return false.
# =============================================================================
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isBalanced(self, root):
        if not root:
            return True

        return abs(self.getHeight(root.left) - self.getHeight(root.right)) < 2 and self.isBalanced(root.left) and self.isBalanced(root.right)

    def getHeight(self, root):
        if not root:
            return 0

        return 1 + max(self.getHeight(root.left), self.getHeight(root.right))
# =============================================================================
#     def isBalanced(self, root):
#         """
#         :type root: TreeNode
#         :rtype: bool
#         """
#         return self.helper(root) != -1
#     
#     def helper(self, root):
#         if root == None:
#             return 0
#         
#         left = self.helper(root.left)
#         if left == -1: return -1
#         right = self.helper(root.right)
#         if right == -1: return -1
#         
#         if abs(left - right) <= 1:
#             return max(left, right) + 1
#         else:
#             return -1
# =============================================================================
