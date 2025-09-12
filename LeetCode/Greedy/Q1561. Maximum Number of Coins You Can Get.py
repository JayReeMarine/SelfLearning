#https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/

from typing import List

class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        piles.sort()
        res = 0
        taken = len(piles)//3
        for i in range(taken,len(piles),2):
            res += piles[i]
        return res
        