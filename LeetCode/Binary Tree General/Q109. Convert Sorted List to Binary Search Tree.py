#https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/

from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:

        def build(sub):
            if not sub:
                return None
            if not sub.next:
                return TreeNode(sub.val)

            slow = sub
            fast = sub
            prev = None
            while fast and fast.next:
                prev = slow
                slow = slow.next
                fast = fast.next.next
                    
            root = TreeNode(slow.val)
            prev.next = None
            root.left = build(sub)
            root.right = build(slow.next)
            return root
        
        return build(head)