
# Website : https://leetcode.com/problems/linked-list-cycle/

# Definition for a singly-linked list node
from typing import Optional

class ListNode:
    def __init__(self, x):
        self.val = x  # Value of the node
        self.next = None  # Pointer to the next node in the list


class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        """
        Detects if a linked list has a cycle using the two-pointer approach (Floyd's Cycle Detection Algorithm).
        
        Parameters:
        head (Optional[ListNode]): The head of the linked list.
        
        Returns:
        bool: True if there is a cycle, False otherwise.
        """
        # Create a dummy node to handle edge cases (e.g., empty list)
        data = ListNode()
        data.next = head
        
        # Initialize two pointers: fast and slow
        fast = data  # Fast pointer moves two steps at a time
        slow = data  # Slow pointer moves one step at a time

        # Traverse the list while ensuring the fast pointer and its next node are valid
        while fast and fast.next:
            # Move the fast pointer two steps forward
            fast = fast.next.next
            
            # Move the slow pointer one step forward
            slow = slow.next
            
            # If the fast pointer meets the slow pointer, a cycle is detected
            if fast == slow:
                return True
        
        # If the loop ends, no cycle exists
        return False