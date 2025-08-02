#https://leetcode.com/problems/print-binary-tree/description/

from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def printTree(self, root: Optional[TreeNode]) -> List[List[str]]:
        
        def dfs_height(root):
            if not root:
                return 0            
            return max(dfs_height(root.left), dfs_height(root.right)) + 1

        def fill(res, node, depth, left, right):
            if not node:
                return        
            
            mid = (left + right) // 2
            res[depth][mid] = str(node.val)
            fill(res, node.left, depth + 1, left, mid - 1)
            fill(res, node.right, depth + 1, mid + 1, right)

        h = dfs_height(root) - 1
        row = 2**(h+1) - 1

        res = [["" for _ in range(row)] for _ in range(h+1)]
        fill(res, root, 0, 0, len(res[0]) - 1)

        return res
