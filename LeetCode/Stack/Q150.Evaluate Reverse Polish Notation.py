from collections import deque
from typing import List

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        """
        Evaluates an arithmetic expression in Reverse Polish Notation (RPN).

        Args:
        tokens (List[str]): A list of strings representing the RPN expression.

        Returns:
        int: The result of the evaluation.
        """

        # Step 1: Initialize an empty stack to store numbers and intermediate results
        stack = deque()

        # Step 2: Iterate through the list of tokens
        for i in tokens:
            if i not in ['+', '-', '*', '/']:  
                # If the token is a number, convert it to an integer and push it onto the stack
                stack.append(int(i))
            else:
                # Step 3: Pop the last two numbers from the stack (first operand is the second popped value)
                first = stack.pop()   # Operand 1 (Top of stack)
                second = stack.pop()  # Operand 2 (Second in stack)

                # Step 4: Perform the arithmetic operation
                if i == '+':
                    stack.append(second + first)  # Addition
                elif i == '-':
                    stack.append(second - first)  # Subtraction
                elif i == '*':
                    stack.append(second * first)  # Multiplication
                elif i == '/':
                    # Perform division and truncate toward zero using int()
                    stack.append(int(second / first))  

        # Step 5: The final result will be the last value remaining in the stack
        return stack.pop()
