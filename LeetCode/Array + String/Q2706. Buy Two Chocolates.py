#https://leetcode.com/problems/buy-two-chocolates/

from collections import List

class Solution:
    def buyChoco(self, prices: List[int], money: int) -> int:
        prices.sort()
        total  = prices[0] + prices[1]

        if total <= money:
            return money - total
        else:
            return money

        

        

        