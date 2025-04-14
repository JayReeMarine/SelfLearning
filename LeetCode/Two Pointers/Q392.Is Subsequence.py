#https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        """
        Determines if the string 's' is a subsequence of string 't'.
        
        Args:
        s (str): The target subsequence string.
        t (str): The main string in which we check for the subsequence.

        Returns:
        bool: True if 's' is a subsequence of 't', False otherwise.
        """

        # Convert strings to lists for easier character comparison (not necessary in Python)
        s = list(s)  
        t = list(t)  

        # Two pointers: 'i' for s (subsequence) and 'j' for t (main string)
        i = 0  # Pointer for 's'
        j = 0  # Pointer for 't'

        # Iterate through both strings
        while i < len(s) and j < len(t):
            if s[i] == t[j]:  # If characters match, move 'i' forward
                i += 1
            j += 1  # Always move 'j' forward to continue scanning 't'

        # If 'i' reaches the length of 's', all characters in 's' were found in 't' in order
        return i == len(s)


Solution = Solution()

s = "abc"
t = "ahbgdc"
print(Solution.isSubsequence(s,t))  # Output: True

s = "axc"
t = "ahbgdc"
print(Solution.isSubsequence(s,t))  # Output: False
