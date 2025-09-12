#https://leetcode.com/problems/remove-nodes-from-linked-list/description/

# Definition for singly-linked list.

from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def reverseList(head: Optional[ListNode]) -> Optional[ListNode]:
            prev = None
            curr = head

            while curr:
                next_node = curr.next
                curr.next = prev
                prev = curr
                curr = next_node
            
            return prev

        if head is None or head.next is None:
            return head

        rev = reverseList(head)
        dummy = ListNode(0)
        tail = dummy
        max_val = -1
        curr = rev
        while curr:
            if curr.val >= max_val:
                max_val = curr.val
                tail.next = ListNode(curr.val)
                tail = tail.next

            curr= curr.next
        
        return reverseList(dummy.next)
            


        