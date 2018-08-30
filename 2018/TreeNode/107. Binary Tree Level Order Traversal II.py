# -*- coding: utf-8 -*-
"""
Created on Thu Aug 30 21:33:18 2018

@author: wufan
# =============================================================================
# Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
# 
# For example:
# Given binary tree [3,9,20,null,null,15,7],
#     3
#    / \
#   9  20
#     /  \
#    15   7
# return its bottom-up level order traversal as:
# [
#   [15,7],
#   [9,20],
#   [3]
# ]
# =============================================================================
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
# =============================================================================
#         用一个List 存放每一层的节点
# =============================================================================
        answ, L = [], [root]
        while L and root:
            answ.insert(0,[n.val for n in L])
            L = [ C for N in L for C in (N.left,N.right) if C ]
        return answ
                
# =============================================================================
#         if root is None:
#             return []
#         queue = [root, None]
#         retList = [[]]
# 
#         i = 0
#         while True:
#             node = queue[i]
# 
#             if node is None:
#                 if i == len(queue)-1:
#                     break
#                 else:
#                     queue.append(None)
#                     retList.append([]) # start new layer
#             else:
#                 retList[-1].append(node.val)
#                 if node.left is not None:
#                     queue.append(node.left)
#                 if node.right is not None:
#                     queue.append(node.right)
# 
#             i += 1
#         return retList[::-1]
# =============================================================================
