#https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150

from collections import defaultdict

class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        """
        Determines if two strings `s` and `t` are isomorphic.
        Two strings are isomorphic if characters in `s` can be replaced to get `t`,
        while maintaining a one-to-one mapping.

        Args:
        s (str): First input string.
        t (str): Second input string.

        Returns:
        bool: True if the two strings are isomorphic, False otherwise.
        """

        # Create two dictionaries to track character mappings
        sCounter = defaultdict(str)  # Maps characters in `s` to characters in `t`
        tCounter = defaultdict(str)  # Maps characters in `t` to characters in `s`

        # Iterate through each character in both strings
        for i in range(len(s)):
            c1, c2 = s[i], t[i]  # Extract corresponding characters

            # Check if the mapping is consistent:
            # 1. If c1 is already mapped to a character, it must match c2
            # 2. If c2 is already mapped to a character, it must match c1
            if (c1 in sCounter and sCounter[c1] != c2) or (c2 in tCounter and tCounter[c2] != c1):
                return False  # Mismatch found, so not isomorphic

            # Establish bidirectional mapping
            sCounter[c1] = c2
            tCounter[c2] = c1

        return True  # If all mappings are consistent, the strings are isomorphic



Solution = Solution()
print(Solution.isIsomorphic("egg", "add"))  # True

print(Solution.isIsomorphic("foo", "bar"))  # False

print(Solution.isIsomorphic("bbbaaaba", "aaabbbba"))  # False