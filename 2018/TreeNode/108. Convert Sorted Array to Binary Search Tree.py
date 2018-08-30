# -*- coding: utf-8 -*-
"""
Created on Thu Aug 30 21:54:09 2018

@author: wufan
# =============================================================================
# Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
# 
# For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the 
# two subtrees of every node never differ by more than 1.
# 
# Example:
# 
# Given the sorted array: [-10,-3,0,5,9],
# 
# One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
# 
#       0
#      / \
#    -3   9
#    /   /
#  -10  5
# =============================================================================
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if not nums:
            return None

        mid = len(nums) // 2

        root = TreeNode(nums[mid])
        root.left = self.sortedArrayToBST(nums[:mid])
        root.right = self.sortedArrayToBST(nums[mid+1:])
        return root
    
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        
# =============================================================================
#         fastest solution
#     def sortedArrayToBST(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: TreeNode
#         """        
#         ret_list = []
#         self.gen_indices(ret_list, nums, 0, len(nums), 0)
#         return ret_list
#     
#     def gen_indices(self, ret_list, nums, lo, hi, cur_index):
#         if lo >= hi:
#             return
#         while cur_index > len(ret_list)-1:
#             ret_list.append(None)
#         mid = (hi + lo)//2
#         ret_list[cur_index] = nums[mid]
#         
#         self.gen_indices(ret_list, nums, lo, mid, 2*cur_index+1)
#         self.gen_indices(ret_list, nums, mid + 1, hi, 2*cur_index+2)
# =============================================================================
