#https://leetcode.com/problems/min-stack/?envType=study-plan-v2&envId=top-interview-150


from collections import deque

class MinStack:
    """
    MinStack class implements a stack that supports:
    - push(val): Add an element to the stack.
    - pop(): Remove the top element from the stack.
    - top(): Retrieve the top element without removing it.
    - getMin(): Retrieve the minimum element in the stack in O(1) time.
    
    Uses an auxiliary stack (minStack) to track the minimum value at each state.
    """

    def __init__(self):
        """
        Initializes the main stack and an auxiliary minStack to track minimum values.
        """
        self.stack = deque()      # Standard stack to store all values
        self.minStack = deque()   # Stack to store the minimum values

    def push(self, val: int) -> None:
        """
        Pushes `val` onto the stack. 
        If `val` is smaller than or equal to the current minimum, it is also pushed to `minStack`.

        Time Complexity: O(1)
        """
        self.stack.append(val)

        # If minStack is empty or `val` is less than or equal to the current minimum, push it onto minStack
        if not self.minStack or val <= self.minStack[-1]:
            self.minStack.append(val)

    def pop(self) -> None:
        """
        Removes the top element from the stack.
        If the popped element is the current minimum, also remove it from minStack.

        Time Complexity: O(1)
        """
        if self.stack:
            poppedValue = self.stack.pop()

            # If the popped value is the current minimum, remove it from minStack as well
            if poppedValue == self.minStack[-1]:
                self.minStack.pop()

    def top(self) -> int:
        """
        Retrieves the top element of the stack without removing it.

        Time Complexity: O(1)
        """
        return self.stack[-1]  # Get the last element in the main stack

    def getMin(self) -> int:
        """
        Retrieves the minimum element in the stack in O(1) time.
        The minimum value is always at the top of minStack.

        Time Complexity: O(1)
        """
        return self.minStack[-1]  # The last element in minStack is always the minimum
