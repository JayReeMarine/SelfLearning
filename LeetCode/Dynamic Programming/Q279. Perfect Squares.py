#https://leetcode.com/problems/perfect-squares/description/

import math
from typing import List

class Solution:
    def numSquares(self, n: int) -> int:
        memo = {}
        def dp(n):
            if n <= 1:
                return n
            if n in memo:
                return memo[n]
            if math.isqrt(n) ** 2 == n:
                memo[n] = 1
                return 1
            
            res = float('inf')
            for i in range(1, math.isqrt(n) + 1):
                res = min(res, dp(n- i*i) + 1)
            
            memo[n] = res
            return res
            

        return dp(n)
            
            


