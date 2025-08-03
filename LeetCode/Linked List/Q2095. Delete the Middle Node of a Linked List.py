#https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return None

        slow = head
        fast = head
        prev = None
        while fast.next is not None:
            prev = slow
            slow = slow.next
            if fast.next.next is None:
                fast = fast.next
            else:
                fast = fast.next.next
        
        prev.next = slow.next
        return head
