#https://leetcode.com/problems/first-unique-character-in-a-string/description/
from collections import Counter

class Solution:
    def firstUniqChar(self, s: str) -> int:
        count = Counter(s)

        for i, j in enumerate(s):
            if count[j] == 1:
                return i
        
        return -1