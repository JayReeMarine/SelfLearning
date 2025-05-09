#https://leetcode.com/problems/number-of-wonderful-substrings/description/?envType=problem-list-v2&envId=hash-table

from collections import defaultdict
class Solution:
    def wonderfulSubstrings(self, word: str) -> int:
        mask = 0
        res = 0
        count = defaultdict(int)
        count[0] = 1

        for ch in word:
            i = ord(ch) - ord('a')
            mask ^= (1 << i)

            res += count[mask]

            for j in range(10):
                res += count[mask ^ (1 << j)]
            
            count[mask] += 1
        return res


