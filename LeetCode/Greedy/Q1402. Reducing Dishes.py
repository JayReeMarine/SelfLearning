#https://leetcode.com/problems/reducing-dishes/description/

from typing import List

class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        # satisfaction = sorted(satisfaction)
        # res = 0
        # for i in range(len(satisfaction)-1,-1,-1):
        #     cur = satisfaction[i:]
        #     val = 0
        #     for j in range(len(cur)):
        #         val += (j+1) * cur[j]
        #     res = max(res,val)

        # return res
        

        satisfaction.sort()
        running = 0   
        ans = 0
        
        for x in reversed(satisfaction):
            running += x
            if running <= 0:  
                break
            ans += running
        return ans
        