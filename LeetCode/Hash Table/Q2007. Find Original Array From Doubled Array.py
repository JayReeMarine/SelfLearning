#https://leetcode.com/problems/find-original-array-from-doubled-array/description/

from typing import List
from collections import defaultdict

class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        if len(changed) % 2 != 0:
            return []

        counter = defaultdict(int)
        for i in changed:
            counter[i] += 1
        
        res = []
        for num in sorted(counter.keys()):
            while counter[num] > 0:
                if counter[num * 2] <= 0:
                    return []
                counter[num] -= 1
                counter[num * 2] -= 1
                res.append(num)

                if counter[num] == 0:
                    del counter[num]
                if counter[num * 2] == 0:
                    del counter[num * 2]
        
        return res
