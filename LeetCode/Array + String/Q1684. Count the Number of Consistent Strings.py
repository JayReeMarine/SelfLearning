#https://leetcode.com/problems/count-the-number-of-consistent-strings/description/

from typing import List

class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        allowed_set = set(allowed)
        res = 0

        for word in words:
            if all(ch in allowed_set for ch in word):
                res += 1
        return res