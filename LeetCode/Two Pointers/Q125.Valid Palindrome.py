#https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150


class Solution:
    def isPalindrome(self, s: str) -> bool:
        """
        Determines if the given string is a palindrome, considering only alphanumeric characters and ignoring cases.
        
        Args:
        s (str): The input string.

        Returns:
        bool: True if the string is a palindrome, False otherwise.
        """

        # Step 1: Remove all spaces from the string
        s = s.replace(" ", "")

        # Step 2: Convert the string to lowercase to ignore case differences
        s = s.lower()

        # Step 3: Keep only alphanumeric characters (letters and digits) and remove all special characters
        s = ''.join(e for e in s if e.isalnum())

        # Step 4: Check if the processed string is equal to its reverse
        return s == s[::-1]

    
Solution = Solution()
s = "A man, a plan, a canal: Panama"
print(Solution.isPalindrome(s))  # Output: True
