#https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=problem-list-v2&envId=dynamic-programming


from typing import List

class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        dp  = { len(cost) : 0}

        for i in range(len(cost)-1, -1, -1):
            if i + 1 == len(cost):
                dp[i] = cost[i]
            elif i +2 == len(cost):
                dp[i] = min(dp[i+1] + cost[i], cost[i])
            else:
                dp[i] = min(dp[i+1] + cost[i], dp[i+2] + cost[i])
        
        return min(dp[0],dp[1])