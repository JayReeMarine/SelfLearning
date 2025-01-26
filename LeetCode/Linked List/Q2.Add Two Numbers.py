#https://leetcode.com/problems/add-two-numbers/?envType=study-plan-v2&envId=top-interview-150

from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        """
        Adds two numbers represented as linked lists.
        Each linked list stores a number in reverse order, where each node contains a single digit.
        Returns a new linked list representing the sum of the two numbers.

        Args:
        l1 (Optional[ListNode]): The head of the first linked list.
        l2 (Optional[ListNode]): The head of the second linked list.

        Returns:
        Optional[ListNode]: The head of the new linked list containing the sum of the numbers.
        """

        # Initialize a dummy node for the result linked list.
        res = ListNode()
        # `current` pointer to traverse and build the result linked list.
        current = res

        # Initialize the carry value for addition.
        carry = 0

        # Iterate through both linked lists until there are no more nodes and no carry.
        while l1 or l2 or carry:
            # Get the value of the current node from l1, or 0 if l1 is None.
            v1 = l1.val if l1 else 0
            # Get the value of the current node from l2, or 0 if l2 is None.
            v2 = l2.val if l2 else 0

            # Add the two values and the carry from the previous addition.
            v = v1 + v2 + carry

            # Calculate the new carry (integer division by 10).
            carry = v // 10
            # Calculate the value for the current node (remainder of division by 10).
            v = v % 10

            # Create a new node with the calculated value and link it to the result list.
            current.next = ListNode(v)
            # Move the `current` pointer to the next node in the result list.
            current = current.next

            # Move to the next node in l1 if it exists.
            l1 = l1.next if l1 else None
            # Move to the next node in l2 if it exists.
            l2 = l2.next if l2 else None

        # Return the next node of the dummy node, which is the head of the result linked list.
        return res.next