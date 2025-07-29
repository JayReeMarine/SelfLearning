#https://leetcode.com/problems/ransom-note/description/

from collections import Counter
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        return True if Counter(ransomNote) - Counter(magazine) == {} else False