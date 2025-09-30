#https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def build(sub):
            if not sub:
                return
            idx = len(sub)//2
            root = TreeNode(sub[idx])
            root.left = build(sub[:idx])
            root.right = build(sub[idx+1:])
            return root

        return build(nums)