#https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

from typing import List


class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        def can_ship(cap) -> bool:
            day = 1
            count = 0
            for w in weights:
                if count + w > cap:
                    day += 1
                    count = 0
                count += w
            return day <= days
        
        low, high = max(weights), sum(weights)
        res = high
        while low <= high:
            mid = (low+high) // 2
            if can_ship(mid):
                res = min(res,mid)
                high = mid - 1
            else:
                low = mid + 1
        
        return res


        # max_weights = max(weights)
        # sum_weights = sum(weights)
        # print(max_weights) 10
        # print(sum_weights) 55
        # for i in range(max_weights, sum_weights+1):
        #     day = 0
        #     count = 0
        #     for j in range(len(weights)):
        #         if count == 0 or count + weights[j] > i:
        #             day += 1
        #             count = weights[j]
        #         else:
        #             count += weights[j]
            
        #     if day <= days:
        #         return i

