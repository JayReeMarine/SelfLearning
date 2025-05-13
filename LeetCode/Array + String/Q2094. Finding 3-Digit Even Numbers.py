#https://leetcode.com/problems/finding-3-digit-even-numbers/description/?envType=daily-question&envId=2025-05-12

from itertools import permutations
from typing import List

class Solution:
    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        res = set()
        for a, b, c in permutations(digits, 3):
            if a == 0:
                continue
            num = 100 * a + 10 * b + c
            if num %2 == 0:
                res.add(num)
        
        return sorted(res)

