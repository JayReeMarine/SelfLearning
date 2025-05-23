#https://leetcode.com/problems/same-tree/description/?envType=study-plan-v2&envId=top-interview-150


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        
        if not p and not q:
            return True
        elif (p and not q) or (not p and q):
            return False
        
        if p.val != q.val:
            return False

        
        if (self.isSameTree(p.left,q.left) and self.isSameTree(p.right,q.right)):
            return True
        else:
            return False
#time complexity : O(n+m)
#space complexity: O(h_p + h_q) where h_p is the height of p and h_q is the height of q