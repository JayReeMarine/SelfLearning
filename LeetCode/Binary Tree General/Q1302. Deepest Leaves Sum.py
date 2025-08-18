#https://leetcode.com/problems/deepest-leaves-sum/description/

from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
      self.maxDepth = -1
      self.sumAtMax = 0

      def dfs(node, d):
        if not node:
          return
        if d > self.maxDepth:
          self.maxDepth = d
          self.sumAtMax = node.val
        elif d == self.maxDepth:
          self.sumAtMax += node.val
        
        dfs(node.left, d + 1)
        dfs(node.right, d + 1)

      dfs(root, 0)  
      return self.sumAtMax

      # def findDeepest(root, depth):
      #     if not root:
      #       return 0
          
      #     depth = max(findDeepest(root.left, depth),findDeepest(root.right, depth))

      #     return depth + 1
      
      # def deepestSum(root, max_depth, cur_depth):
      #   if not root:
      #     return 0
      #   if cur_depth == max_depth:
      #     return root.val
        
      #   return (deepestSum(root.left, max_depth, cur_depth+1) +
      #           deepestSum(root.right, max_depth, cur_depth+1)
      #   )
      
      # max_depth = findDeepest(root,1)
      # return deepestSum(root, max_depth, 1)



        
      
      


