#https://leetcode.com/problems/find-minimum-log-transportation-cost/description/

class Solution:
    def minCuttingCost(self, n: int, m: int, k: int) -> int:
        if n <= k and m <= k:
            return 0

        cost = 0
        thridLog = 0

        while n > k or m > k :
            if n > k:
                n -= k
                thridLog += k
                cost += n * thridLog
            
            if m > k:
                m -= k
                thridLog += k
                cost += m * thridLog
        
        return cost
            
