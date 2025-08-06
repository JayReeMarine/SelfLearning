#https://leetcode.com/problems/fruits-into-baskets-ii/

from typing import List

class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        res = 0
        used = [False] * len(fruits)
        for i in range(len(fruits)):
            placed = False
            for j in range(len(baskets)):
                if fruits[i] <= baskets[j] and used[j] == False:
                    used[j] = True
                    placed = True
                    break
            if not placed:
                res += 1
        
        return res

