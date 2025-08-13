#https://leetcode.com/problems/maximum-tastiness-of-candy-basket/description/

from typing import List

class Solution:
    def maximumTastiness(self, price: List[int], k: int) -> int:
        price.sort()
        
        def good(target):
            candy = 0
            last = -10 **20

            for x in price:
                if x - last >= target:
                    candy += 1
                    last = x
            return candy >= k
        
        left = 0
        right = price[-1] - price[0]
        while left < right:
            mid = (left + right + 1) // 2

            if good(mid):
                left = mid
            else:
                right = mid -1
        return left
        