#https://leetcode.com/problems/maximum-ice-cream-bars/description/

from collections import List

class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        amount = 0

        costs.sort()

        for i in range(len(costs)):
            if coins - costs[i] >= 0:
                amount +=1
                coins -= costs[i]
            else:
                return amount
        
        return amount
