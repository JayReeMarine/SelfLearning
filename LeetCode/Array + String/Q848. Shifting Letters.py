#https://leetcode.com/problems/shifting-letters/description/

from typing import List

class Solution:
    def shiftingLetters(self, s: str, shifts: List[int]) -> str:
        total = sum(shifts)
        s = list(s)
        for i in range(len(s)):
            s[i] = chr((ord(s[i]) - ord('a') + total) % 26 + ord('a'))
            total -= shifts[i]
            

        return "".join(s)
