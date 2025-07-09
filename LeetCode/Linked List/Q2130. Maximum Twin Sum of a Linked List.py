#https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

# Definition for singly-linked list.

from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        
        # Find medium node
        slow = head
        fast = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        
        max_sum = 0
        first = head
        reverse_list = self.reverse(slow)
        while reverse_list:
            max_sum = max(max_sum, first.val+ reverse_list.val)
            first = first.next
            reverse_list = reverse_list.next
        
        return max_sum
        
    def reverse(self, head):
        prev = None
        curr = head

        while curr:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
        
        return prev
        