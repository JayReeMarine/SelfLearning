#https://leetcode.com/problems/find-the-highest-altitude/description/


from typing import List
class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        res = [0]
        curr = res[0]
        for i in range(len(gain)):
            curr = gain[i] + curr
            res.append(curr)
        
        return max(res)

        # altitude = 0

        # max_val = 0

        # for i in gain:
        #     altitude += i
        #     max_val = max(max_val, altitude)
        
        # return max_val