#https://leetcode.com/problems/number-of-zero-filled-subarrays/description/

from typing import List

class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        # count = 0
        # res = 0

        # for num in nums:
        #     if num == 0:
        #         count += 1
        #     else:
        #         res += int((count+1)*(count)/2)
        #         count = 0
        
        # res += int((count+1)*(count)/2)
        # return res

        res = 0
        count = 0
        for x in nums:
            if x == 0:
                count += 1     
                res += count   
            else:
                count = 0
        return res