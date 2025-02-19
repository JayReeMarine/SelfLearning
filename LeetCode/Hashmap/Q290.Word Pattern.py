#https://leetcode.com/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150
from collections import defaultdict

class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        """
        Determines if a given pattern matches a string `s`, 
        where each character in `pattern` maps to a unique word in `s`.

        Args:
        pattern (str): A string containing single characters representing a pattern.
        s (str): A sentence consisting of words separated by spaces.

        Returns:
        bool: True if the pattern matches the word sequence, False otherwise.
        """

        # Step 1: Create two dictionaries to track character-to-word and word-to-character mappings
        pCounter = defaultdict(str)  # Maps pattern characters → words
        sCounter = defaultdict(str)  # Maps words → pattern characters

        # Step 2: Split `s` into a list of words
        s = s.split()  

        # Step 3: If lengths are different, return False immediately
        if len(pattern) != len(s):
            return False  # Different lengths mean they can't match

        # Step 4: Iterate through the pattern and corresponding words
        for i in range(len(pattern)):
            c1, c2 = pattern[i], s[i]  # c1 = pattern character, c2 = corresponding word in `s`

            # Step 5: Check if the mapping is consistent
            # If `c1` is already mapped to a word, it must match `c2`
            # If `c2` is already mapped to a pattern character, it must match `c1`
            if (c1 in pCounter and pCounter[c1] != c2) or (c2 in sCounter and sCounter[c2] != c1):
                return False  # Conflict found, not a valid pattern

            # Step 6: Establish a bidirectional mapping
            pCounter[c1] = c2
            sCounter[c2] = c1
        
        return True  # If all mappings are valid, return True


Solution = Solution()
print(Solution.wordPattern("abba", "dog cat cat dog"))  # True
print(Solution.wordPattern("abba", "dog cat cat fish"))  # False
print(Solution.wordPattern("aaaa", "dog cat cat dog"))  # False