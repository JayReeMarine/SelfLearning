#https://leetcode.com/problems/maximum-number-of-pairs-in-array/description/

from collections import Counter
from typing import List

class Solution:
    def numberOfPairs(self, nums: List[int]) -> List[int]:
        cnt = Counter(nums)
        pair = 0
        leftOver = 0

        for i in cnt.keys():
            pair += cnt[i] //2
            if cnt[i] % 2 != 0:
                leftOver += 1

        return [pair,leftOver]
