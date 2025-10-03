#https://leetcode.com/problems/water-bottles-ii/description/

class Solution:
    def maxBottlesDrunk(self, numBottles: int, numExchange: int) -> int:
        drunk = numBottles
        empty = numBottles
        fee = numExchange

        while empty >= fee:
            empty -= fee
            fee += 1
            drunk += 1
            empty += 1
        
        return drunk
