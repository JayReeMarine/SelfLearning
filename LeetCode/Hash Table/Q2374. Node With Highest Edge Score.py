#https://leetcode.com/problems/node-with-highest-edge-score/description/

from typing import List

class Solution:
    def edgeScore(self, edges: List[int]) -> int:
        n = len(edges)
        cnt = [0] * n
        maxVal = -1
        res = 0
    
        for i in range(n):
            idx = edges[i]
            cnt[idx] += i
            if cnt[idx] > maxVal or (cnt[idx] == maxVal and idx < res):
                maxVal = cnt[idx]
                res = idx

        return res
        # return cnt.index(max(cnt))
