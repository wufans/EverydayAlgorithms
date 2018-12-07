# -*- coding: utf-8 -*-
#@author: WuFan
"""
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
"""


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSubtree(self, s, t):
        """
        :type s: TreeNode
        :type t: TreeNode
        :rtype: bool
        """
        #30%
    #     if s == None and t != None:
    #         return False
    #     if s != None and t == None:
    #         return True
    #     root = [s]
    #     for node in root:
    #         if node.val == t.val:
    #             if self.compare(node,t) == True:
    #                 return True
    #         if node.left != None:
    #             root.append(node.left)
    #         if node.right != None:
    #             root.append(node.right)
    #     return False
    # def compare(self,node1,node2):
    #     if node1.left and node2.left:
    #         if node1.left.val != node2.left.val or self.compare(node1.left,node2.left) == False:
    #             return False
    #     elif (node1.left == None and node2.left != None) or (node1.left !=None and node2.left == None):
    #         return False
    #     if node1.right and node2.right:
    #         if node1.right.val != node2.right.cal or self.compare(node1.right,node2.right)==False:
    #             return False
    #     elif (node1.right == None and node2.right != None) or (node1.right != None and node2.right == None):
    #         return False
    #     return True
        def compare(s, t, flag):
            if not (s or t):
                return True
            if not s or not t:
                return False
            if flag == False and s.val != t.val:
                return False

            if s.val == t.val:
                if compare(s.left, t.left, False) and compare(s.right, t.right, False):
                    return True
            return compare(s.left, t, True) or compare(s.right, t, True)

        return compare(s, t, True)
