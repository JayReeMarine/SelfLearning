#https://leetcode.com/problems/maximum-binary-tree/description/

from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        def build(sub):
            if not sub:
                return None
            
            # 1) find the max value, index
            max_val = max(sub)
            idx = sub.index(max_val)

            # 2) create a node with the max value
            root = TreeNode(max_val)

            # 3) recursively build left and right subtrees from the left/right
            root.left = build(sub[:idx])
            root.right = build(sub[idx+1:])
            return root
        
        return build(nums)
