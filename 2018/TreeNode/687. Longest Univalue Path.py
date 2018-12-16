# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def longestUnivaluePath(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.ans = 0
        def helper(root):
            if not root: return 0, 0                        
            llen = max(helper(root.left)) 
            rlen = max(helper(root.right))                                                                            
            llen = (1 + llen) if root.left and root.left.val == root.val else 0                            
            rlen = (1 + rlen) if root.right and root.right.val == root.val else 0                                        
            self.ans = max(self.ans, llen + rlen)                        
            return llen, rlen
        
        helper(root)
        return self.ans
