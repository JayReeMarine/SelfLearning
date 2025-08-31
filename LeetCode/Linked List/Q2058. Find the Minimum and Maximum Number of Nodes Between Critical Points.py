#https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/

from typing import Optional, List

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        res = []
        i = 1
        prev, curr = head, head.next

        while curr and curr.next:
            if (prev.val < curr.val > curr.next.val) or (prev.val > curr.val < curr.next.val):
                res.append(i)
            
            prev, curr = curr, curr.next
            i += 1

        if len(res) < 2:
            return [-1, -1]

        maxDist = res[-1] - res[0]
        minDist = float('inf')
        for i in range(1, len(res)):
            minDist = min(minDist, res[i] - res[i-1])
        
        return [minDist, maxDist]
            

        