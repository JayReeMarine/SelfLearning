#https://leetcode.com/problems/create-binary-tree-from-descriptions/description/

from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        nodes = {}
        children = set()
        for par, child, is_left in descriptions:
            children.add(child)
            if par not in nodes:
                nodes[par] = TreeNode(par)
            if child not in nodes:
                nodes[child] = TreeNode(child)
            
            if is_left:
                nodes[par].left = nodes[child]
            else:
                nodes[par].right = nodes[child]
        
        for p, c, l in descriptions:
            if p not in children:
                return nodes[p]




        # children = set()
        # for _, c, _ in descriptions:
        #     children.add(c)

        # root = None
        # for p, _, _ in descriptions:
        #     if p not in children:
        #         root = p
        #         break

        # left = {}
        # right = {}
        # for p, c, l in descriptions:
        #     if l == 1:
        #         left[p] = c
        #     else:
        #         right[p] = c
        
        # node = {}
        # def get_node(v):
        #     if v not in node:
        #         node[v] = TreeNode(v)
        #     return node[v]
                
        # def addChild(node):
        #     lv = left.get(node.val)
        #     if lv is not None:
        #         node.left = get_node(lv)
        #         addChild(node.left)
        #     rv = right.get(node.val)
        #     if rv is not None:
        #         node.right = get_node(rv)
        #         addChild(node.right)
        
        # root_node = get_node(root)
        # addChild(root_node)
        # return root_node