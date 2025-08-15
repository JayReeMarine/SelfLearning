#https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/

from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(a, b, level):
            if not a or not b:
                return
            if level % 2 == 1:
                a.val, b.val = b.val, a.val
            dfs(a.left, b.right, level+1)
            dfs(a.right, b.left, level+1)
    
        if not root:
            return root
        dfs(root.left, root.right, 1)
        return root