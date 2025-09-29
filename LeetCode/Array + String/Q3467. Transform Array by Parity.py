#https://leetcode.com/problems/transform-array-by-parity/description/

from typing import List

class Solution:
    def transformArray(self, nums: List[int]) -> List[int]:
        oddNum = 0
        evenNum = 0
        res= []

        for num in nums:
            if num % 2 == 0:
                evenNum += 1
            else:
                oddNum += 1

        res.extend([0]*evenNum)
        res.extend([1]*oddNum)

        return res
        
        