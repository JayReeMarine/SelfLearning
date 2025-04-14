
# Website: https://leetcode.com/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-interview-150

# Definition for singly-linked list.
from typing import Optional

#Assume the ListNode class is already defined:
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        """
        Merges two sorted linked lists into a single sorted linked list.
        
        Parameters:
        list1 (Optional[ListNode]): The first sorted linked list.
        list2 (Optional[ListNode]): The second sorted linked list.
        
        Returns:
        Optional[ListNode]: A merged sorted linked list.
        """

        # Create a dummy node to serve as the starting point for the merged list.
        # This simplifies the logic since we don't need to handle the "head" separately.
        data = ListNode()

        # Keep a reference to the dummy node to return the merged list later.
        head = data

        # While both lists have nodes remaining, compare their values.
        while list1 and list2:
            if list1.val < list2.val:  # If the current node in list1 has a smaller value:
                data.next = list1  # Attach list1's node to the merged list.
                list1 = list1.next  # Move to the next node in list1.
            else:  # If the current node in list2 has a smaller or equal value:
                data.next = list2  # Attach list2's node to the merged list.
                list2 = list2.next  # Move to the next node in list2.
            
            # Move the "data" pointer to the next position in the merged list.
            data = data.next

        # At this point, at least one of the lists is empty.
        # If list1 still has nodes remaining, attach the rest of list1 to the merged list.
        if list1:
            data.next = list1

        # If list2 still has nodes remaining, attach the rest of list2 to the merged list.
        elif list2:
            data.next = list2

        # The merged list starts from "head.next" since "head" is a dummy node.
        return head.next
    

    # Create two sorted linked lists
list1 = ListNode([1, 2, 4])
list2 = ListNode([1, 3, 4])

# Merge the linked lists
solution = Solution()
merged_list = solution.mergeTwoLists(list1, list2)

# Print the merged linked list
print(merged_list)