#https://leetcode.com/problems/find-the-number-of-winning-players/description/

from typing import List

class Solution:
    def winningPlayerCount(self, n: int, pick: List[List[int]]) -> int:
        counts = [[0] * 11 for _ in range(n)]
        won = set()

        for x, y in pick:
            if x in won:
                continue
            
            counts[x][y] += 1

            if counts[x][y] > x:
                won.add(x)
        
        return len(won)