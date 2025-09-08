#https://leetcode.com/problems/find-center-of-star-graph/description/


from typing import List
from collections import Counter

class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        a1, b1 = edges[0]
        a2, b2 = edges[1]
        if a1 == a2 or a1 == b2:
            return a1
        else:
            return b1


        # cnt = Counter()
        # n = len(edges)
        # for a,b in edges:
        #     cnt[a] += 1
        #     cnt[b] += 1
        #     if cnt[a] == n:
        #         return a
        #     elif cnt[b] == n:
        #         return b