from typing import Optional
#https://leetcode.com/problems/copy-list-with-random-pointer/submissions/1521177128/?envType=study-plan-v2&envId=top-interview-150

# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)       
        self.next = next          
        self.random = random      

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        
        # If the input list is empty, return None
        if head is None:
            return None
        
        # Create a dictionary to map original nodes to their corresponding copied nodes
        # Initialize with {None: None} to handle random pointers pointing to None
        res = {None: None}
        current = head

        # First pass: Create all nodes (with values only) and map original nodes to new nodes
        while current:
            newNode = Node(current.val)  # Create a new node with the same value as the current node
            res[current] = newNode       # Map the original node to the new node in the dictionary
            current = current.next       # Move to the next node in the original list
        
        # Reset the current pointer to the head of the original list
        current = head

        # Second pass: Assign `next` and `random` pointers for the copied nodes
        while current:
            copy = res[current]              # Get the copied node corresponding to the current original node
            copy.next = res[current.next]    # Set the `next` pointer of the copied node
            copy.random = res[current.random] # Set the `random` pointer of the copied node
            current = current.next           # Move to the next node in the original list

        # Return the head of the copied linked list
        return res[head]
