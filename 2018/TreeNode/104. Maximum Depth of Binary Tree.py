# -*- coding: utf-8 -*-
"""
Created on Thu Aug 30 10:56:44 2018

@author: wufan
# =============================================================================
# Given a binary tree, find its maximum depth.
# 
# The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
# return its depth = 3.
# =============================================================================
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:return 0
        def getdepth(node):
            if node.left == None and node.right == None:
                return 1
            
            elif node.left and node.right:
                return max(getdepth(node.left),getdepth(node.right))+1
            elif node.left:
                return getdepth(node.left)+1
            else:
                return getdepth(node.right)+1
        return getdepth(root)
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        
# =============================================================================
#One line solution
# return 1 + max(map(self.maxDepth, (root.left, root.right))) if root else 0
# =============================================================================
# fastest solution
# =============================================================================
#         if root is None:
#         	return 0
#         queue = []
#        	queue.append(root)
#        	depth = 1
#        	a = len(queue)
#        	while len(queue) > 0:
#        		if a == 0:
#        			a = len(queue)
#        			depth += 1
#        		curr = queue.pop(0)
#        		a -= 1
#        		if curr.left is not None:
#        			queue.append(curr.left)
#        		if curr.right is not None:
#        			queue.append(curr.right)
#        	return depth
# =============================================================================
a = TreeNode(3)
a.left = TreeNode(1)
a.right = TreeNode(1)

print(Solution().maxDepth(a))

#b = TreeNode(3)
#print(Solution().maxDepth(b))
