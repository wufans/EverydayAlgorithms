# -*- coding: utf-8 -*-
"""
Created on Thu Aug 30 10:31:27 2018

@author: wufan

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
#        if root and root.right and root.left:
#            right = root.right
#            left = root.left
#            
# =============================================================================
#         def isSym(L,R):
#             if not L and not R: return True
#             if L and R and L.val == R.val: 
#                 return isSym(L.left, R.right) and isSym(L.right, R.left)
#             return False
#         return isSym(root, root)
# 
# =============================================================================
        def isSym(L,R):
            if not L and not R: return True
            if L and R and L.val == R.val: 
                return isSym(L.left, R.right) and isSym(L.right, R.left)
            return False
        if root is None:
            return True
        return isSym(root.left, root.right)
    
# =============================================================================
# Fastest solution  
#  def isSymmetric(self, root):
#         """
#         :type root: TreeNode
#         :rtype: bool
#         """ 
#         if root == None:
#             return True
#         return self.isMirror(root.left, root.right)
#     def isMirror(self, r, t):
# 
#         if r == None and t == None:
#             return True
#         if r == None or t == None:
#             return False
#         if r.val == t.val:  
#             return self.isMirror(r.left, t.right) and self.isMirror(r.right, t.left)
#         else: return False
# =============================================================================
