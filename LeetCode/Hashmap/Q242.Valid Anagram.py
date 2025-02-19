#https://leetcode.com/problems/valid-anagram/?envType=study-plan-v2&envId=top-interview-150
from collections import defaultdict

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        """
        Determines if two strings `s` and `t` are anagrams.
        An anagram means both strings contain the same characters in the same frequency.

        Args:
        s (str): The first input string.
        t (str): The second input string.

        Returns:
        bool: True if `s` and `t` are anagrams, False otherwise.
        """

        # Step 1: If the lengths of `s` and `t` are different, they cannot be anagrams
        if len(s) != len(t):
            return False

        # Step 2: Create a character frequency dictionary
        counter = defaultdict(int)  # Default value is 0 for missing keys

        # Step 3: Count the frequency of each character in `s`
        for i in range(len(s)):
            counter[s[i]] += 1  # Increment count for `s[i]`

        # Step 4: Decrease the count for each character in `t`
        for i in range(len(t)):
            counter[t[i]] -= 1  # Decrement count for `t[i]`
            
            # If count goes negative, `t` contains extra characters not in `s`
            if counter[t[i]] < 0:
                return False

        # Step 5: If all counts are balanced, `s` and `t` are anagrams
        return True

    
Solution = Solution()
print(Solution.isAnagram("anagram", "nagaram"))  # True
print(Solution.isAnagram("rat", "car"))  # False