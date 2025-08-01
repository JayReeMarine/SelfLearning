#https://leetcode.com/problems/perfect-squares/description/

import math
from typing import List
           
class Solution:
    def numSquares(self, n: int) -> int:
        dp = [n] * (n + 1)
        dp[0] = 0

        for target in range(1, n + 1):
            for s in range(1, target + 1):
                square = s * s
                if target < square:
                    break
                dp[target] = min(dp[target], 1 + dp[target - square])
        
        return dp[n]


        # memo = {}
        # def dp(n):
        #     if n <= 1:
        #         return n
        #     if n in memo:
        #         return memo[n]
        #     if math.isqrt(n) ** 2 == n:
        #         memo[n] = 1
        #         return 1
            
        #     res = float('inf')
        #     for i in range(1, math.isqrt(n) + 1):
        #         res = min(res, dp(n- i*i) + 1)
            
        #     memo[n] = res
        #     return res
            

        # return dp(n)
            
            



            


