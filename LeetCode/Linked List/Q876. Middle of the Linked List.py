#https://leetcode.com/problems/middle-of-the-linked-list/


# Definition for singly-linked list.

from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        head_length = self.countNodes(head)
        mid_val = head_length // 2

        for i in range(mid_val):
            head = head.next
        
        return head

    def countNodes(self, head):
        count = 0
        curr = head
        while curr is not None:
            count += 1
            curr = curr.next
        return count