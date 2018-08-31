# -*- coding: utf-8 -*-
"""
Created on Fri Aug 31 10:14:53 2018

@author: wufan

# =============================================================================
# Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
# 
# Note: A leaf is a node with no children.
# 
# Example:
# 
# Given the below binary tree and sum = 22,
# 
#       5
#      / \
#     4   8
#    /   / \
#   11  13  4
#  /  \      \
# 7    2      1
# return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
# =============================================================================
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        #flag = False
        if not root:
            return False
        if root.left == None and root.right == None:
            if sum == root.val:
                return True
            else:
                return False
        elif root.left and root.right:
            return self.hasPathSum(root.left,sum-root.val) or self.hasPathSum(root.right,sum-root.val)
        elif root.left:
            return self.hasPathSum(root.left,sum-root.val)
        else:
            return self.hasPathSum(root.right,sum-root.val)
              
# =============================================================================
#         if not root:
#             return False
#         
#         if not root.left and not root.right and root.val == sum:
#             return True
#         
#         sum -= root.val
#         
#         return self.hasPathSum(root.left, sum) or self.hasPathSum(root.right, sum)
# =============================================================================
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
a = TreeNode(5)
b = TreeNode(1)
c = TreeNode(1)
d = TreeNode(2)
a.left = b
b.left = d
b.right = c
print(Solution().hasPathSum(a,7))
