#https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/

import math
from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head.next == None:
            return head
        
        res = ListNode(head.val)
        cur = res

        while head.next is not None:
            gcd = math.gcd(head.val, head.next.val)
            
            cur.next = ListNode(gcd)
            cur = cur.next

            cur.next = ListNode(head.next.val)
            cur = cur.next

            head = head.next
        
        return res
        
