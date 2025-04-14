
#https://leetcode.com/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-interview-150

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Solution 1

# class Solution:
#     def isSymmetric(self, root: Optional[TreeNode]) -> bool:
#         origin = root
#         compare = self.invertTree(copy.deepcopy(root))
#         return self.isSameTree(origin,compare)
        
#     def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        
#         if not root:
#             return None
        
#         root.left, root.right = root.right, root.left

#         self.invertTree(root.right)
#         self.invertTree(root.left)

#         return root
#     def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        
#         if not p and not q:
#             return True
#         elif (p and not q) or (not p and q):
#             return False
        
#         if p.val != q.val:
#             return False

        
#         if (self.isSameTree(p.left,q.left) and self.isSameTree(p.right,q.right)):
#             return True
#         else:
#             return False


#Solution 2
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True  
        return self.isMirror(root.left, root.right)

    def isMirror(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q:
            return True  
        elif not p or not q:
            return False  
        if p.val != q.val:
            return False  

        return self.isMirror(p.left, q.right) and self.isMirror(p.right, q.left)