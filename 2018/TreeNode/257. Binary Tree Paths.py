# =============================================================================
# Given a binary tree, return all root-to-leaf paths.
# 
# Note: A leaf is a node with no children.
# 
# Example:
# 
# Input:
# 
#    1
#  /   \
# 2     3
#  \
#   5
# 
# Output: ["1->2->5", "1->3"]
# 
# Explanation: All root-to-leaf paths are: 1->2->5, 1->3
# =============================================================================
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """

#         if not root:
#             return []

#         paths = []
#         stack = [(root, str(root.val))]
#         while stack:
#             node, path = stack.pop()
#             if not node.left and not node.right:
#                 paths.append(path)
#             if node.left:
#                 stack.append((node.left, path + '->' + str(node.left.val)))
#             if node.right:
#                 stack.append((node.right, path + '->' + str(node.right.val)))

#         return paths

        def conpath(root, path):
            if root:
                path = path + str(root.val)
                if not root.left and not root.right:
                    paths.append(path)
                else:
                    path = path + "->"
                    conpath(root.left, path)
                    conpath(root.right, path)

        paths = []
        conpath(root, "")
        return paths
