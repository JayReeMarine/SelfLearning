#https://leetcode.com/problems/binary-tree-postorder-traversal/description/

from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self.res = []

        def addEnd(root):
            if not root:
                return
            
            if root.left:
                addEnd(root.left)

            if root.right:
                addEnd(root.right)
            
            self.res.append(root.val)

        
        addEnd(root)
        return self.res