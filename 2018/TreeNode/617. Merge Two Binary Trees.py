# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
Output:
Merged tree:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7


Note: The merging process must start from the root nodes of both trees.
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
    #     if not t1 and not t2:
    #         return None
    #     return self.helper(t1,t2)
    # def helper(self,node1,node2):
    #     tmp = TreeNode(0)
    #     if node1 != None and node2 == None:
    #         tmp = node1
    #     elif node1 == None and node2 != None:
    #         tmp = node2
    #     else:
    #         tmp.val = node1.val+node2.val
    #         if node1.left!= None or node2.left != None:
    #             tmp.left = self.helper(node1.left, node2.left)
    #         if node2.right!= None or node1.right!= None:
    #             tmp.right = self.helper(node1.right, node2.right)
    #     return tmp
        if t1 and t2:
            t1.val += t2.val
            t1.left = self.mergeTrees(t1.left, t2.left)
            t1.right = self.mergeTrees(t1.right, t2.right)
            return t1
        else:
            return t1 or t2
