
# -*- coding: utf-8 -*-
"""
Created on Sat Sep 15 22:39:39 2018

@author: wufan

# =============================================================================
# Invert a binary tree.
# 
# Example:
# 
# Input:
# 
#      4
#    /   \
#   2     7
#  / \   / \
# 1   3 6   9
# Output:
# 
#      4
#    /   \
#   7     2
#  / \   / \
# 9   6 3   1
# Trivia:
# This problem was inspired by this original tweet by Max Howell:
# 
# Google: 90% of our engineers use the software you wrote (Homebrew), 
# but you can’t invert a binary tree on a whiteboard so f*** off.
# =============================================================================
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
    def invertTree(self, root):
        if root:
            root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
            return root
#Maybe make it four lines for better readability:
# =============================================================================
# 
#     def invertTree(self, root):
#         if root:
#             invert = self.invertTree
#             root.left, root.right = invert(root.right), invert(root.left)
#         return root
# #And an iterative version using my own stack:
#         
#     def invertTree(self, root):
#         stack = [root]
#         while stack:
#             node = stack.pop()
#             if node:
#                 node.left, node.right = node.right, node.left
#                 stack += node.left, node.right
#         return root
# =============================================================================
