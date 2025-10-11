#https://leetcode.com/problems/divide-array-into-equal-pairs/description/

from typing import List
from collections import Counter

class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        if len(nums) % 2 != 0:
            return False
        counts = Counter(nums)

        for i in counts.keys():
            if counts[i] %2 != 0:
                return False
        return True

            

