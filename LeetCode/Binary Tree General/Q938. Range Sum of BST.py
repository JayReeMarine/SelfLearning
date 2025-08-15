#https://leetcode.com/problems/range-sum-of-bst/description/

from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        def sumRange(root, low, high):
            if root is None:
                return 0
            if root.val < low:
                return sumRange(root.right, low, high)
            if root.val > high:
                return sumRange(root.left, low, high)
            return (
                root.val
                + sumRange(root.right, low, high)
                + sumRange(root.left, low, high)
            )
        
        return sumRange(root,low,high)