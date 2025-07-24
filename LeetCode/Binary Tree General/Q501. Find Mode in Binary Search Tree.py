#https://leetcode.com/problems/find-mode-in-binary-search-tree/description/

from collections import defaultdict
from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        count = defaultdict(int)


        def dfs(root, count):
            if not root:
                return

            count[root.val] += 1
            if root.left != "None":
                dfs(root.left, count)
            
            if root.right != "None": 
                dfs(root.right, count)

            return count
        
        dfs(root,count)

        max_val = max(count.values())
        res = [key for key,val in count.items() if val == max_val]

        return res
