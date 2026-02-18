#https://leetcode.com/problems/longest-repeating-character-replacement/description/

from collections import Counter

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count = Counter()
        l = 0
        res = 0
        max_freq = 0

        for r in range(len(s)):
            count[s[r]] += 1
            max_freq = max(max_freq, count[s[r]])

            while (r -l +1) - max_freq > k:
                count[s[l]] -= 1
                l += 1
             
            res = max(res, r - l +1 )
        
        return res