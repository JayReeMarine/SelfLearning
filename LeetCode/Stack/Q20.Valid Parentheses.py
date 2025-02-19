#https://leetcode.com/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-interview-150

from collections import deque

class Solution:
    def isValid(self, s: str) -> bool:
        """
        Determines if a given string `s` containing only '(', ')', '{', '}', '[' and ']' 
        is a valid sequence of balanced parentheses.

        Args:
        s (str): The input string containing brackets.

        Returns:
        bool: True if `s` is a valid bracket sequence, False otherwise.
        """

        # Step 1: Use a stack (deque) to track open brackets
        stack = deque()

        # Step 2: Iterate through each character in `s`
        for char in s:

            # Step 3: If it's an opening bracket, push it to the stack
            if char in '(' or char in '[' or char in '{':  # ❌ Incorrect condition
                stack.append(char)

            else:
                # Step 4: If stack is empty, there is no matching open bracket
                if not stack:
                    return False

                # Step 5: Check if the top of the stack matches the closing bracket
                if char == ')' and stack[-1] == '(':
                    stack.pop()
                elif char == ']' and stack[-1] == '[':
                    stack.pop()
                elif char == '}' and stack[-1] == '{':
                    stack.pop()
                else:
                    return False  # Mismatched closing bracket

        # Step 6: If stack is empty, all brackets were matched correctly
        return True if not stack else False  # ✅ Equivalent to `return not stack`
