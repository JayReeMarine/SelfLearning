#https://leetcode.com/problems/sort-array-by-increasing-frequency/description/

from collections import Counter
from typing import List

class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        count = Counter(nums)        
        sortedCnt = sorted(count, key=lambda x: (count[x], -x))

        res = []
        for n in sortedCnt:
            res.extend([n] * count[n])
        
        return res
        