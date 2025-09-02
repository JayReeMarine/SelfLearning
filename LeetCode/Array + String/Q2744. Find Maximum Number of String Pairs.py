#https://leetcode.com/problems/find-maximum-number-of-string-pairs/description/

from typing import List
class Solution:
    def maximumNumberOfStringPairs(self, words: List[str]) -> int:
        seen = set()
        res = 0
        for word in words:
            reverse = word[::-1]
            if reverse in seen:
                res += 1
            else:
                seen.add(word)
        return res