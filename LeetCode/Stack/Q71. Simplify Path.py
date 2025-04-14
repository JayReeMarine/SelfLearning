#https://leetcode.com/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
from collections import deque

class Solution:
    def simplifyPath(self, path: str) -> str:
        """
        Converts an absolute Unix-style file path into its simplified canonical form.

        Args:
        path (str): The absolute path string.

        Returns:
        str: The simplified canonical path.
        """

        # Step 1: Initialize a stack (deque is used for efficient pop operations)
        stack = deque()

        # Step 2: Split the input path by '/'
        path = path.split("/")

        # Step 3: Iterate through each directory/part in the path
        for i in path:
            if i == "." or i == "":  
                # Ignore empty strings (caused by multiple consecutive slashes) 
                # and "." which refers to the current directory.
                continue  
            elif i == "..":
                # ".." moves up to the parent directory, so remove the last directory if stack is not empty.
                if stack:
                    stack.pop()
            else:
                # A valid directory name; add it to the stack.
                stack.append(i)

        # Step 4: Construct the canonical path by joining stack elements with '/'
        canonicalPath = "/" + "/".join(stack)

        return canonicalPath  # Ensure output always starts with "/"
