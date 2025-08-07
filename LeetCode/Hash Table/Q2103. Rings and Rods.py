#https://leetcode.com/problems/rings-and-rods/
from collections import defaultdict

class Solution:
    def countPoints(self, rings: str) -> int:
        counter = defaultdict(str)
        res = 0

        for i in range(0,len(rings),2):
            counter[rings[i+1]] += rings[i]
        
        for key in counter:
            if 'R' in counter[key] and 'G' in counter[key] and 'B' in counter[key]:
                res += 1
        
        return res
