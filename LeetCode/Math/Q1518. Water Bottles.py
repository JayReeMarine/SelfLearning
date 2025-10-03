#https://leetcode.com/problems/water-bottles/description/

class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        res = 0
        while numBottles >= numExchange:
            res += numExchange
            numBottles = numBottles - numExchange + 1

        return res + numBottles