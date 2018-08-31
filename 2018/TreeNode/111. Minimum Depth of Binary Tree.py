# -*- coding: utf-8 -*-
"""
Created on Fri Aug 31 09:52:41 2018

@author: wufan
# =============================================================================
# Given a binary tree, find its minimum depth.
# 
# The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
# 
# Note: A leaf is a node with no children.
# 
# Example:
# 
# Given binary tree [3,9,20,null,null,15,7],
# 
#     3
#    / \
#   9  20
#     /  \
#    15   7
# return its minimum depth = 2.
# =============================================================================
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:return 0
        if root.left == None and root.right == None:
            return 1
        elif root.left and root .right:
            return min(self.minDepth(root.left),self.minDepth(root.right))+1
        elif root.left:
            return self.minDepth(root.left)+1
        else:
            return self.minDepth(root.right)+1
        
# =============================================================================
#         if not root:
#             return 0
#         queue = collections.deque([root])
#         step = 1
#         while queue:
#             size = len(queue)
#             for _ in range(size):
#                 node = queue.popleft()
#                 if not node.left and not node.right:
#                     return step
#                 if node.left:
#                     queue.append(node.left)
#                 if node.right:
#                     queue.append(node.right)
#             step += 1
#          
# =============================================================================
