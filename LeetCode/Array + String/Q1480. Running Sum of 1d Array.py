#https://leetcode.com/problems/running-sum-of-1d-array/description/

from collections import List

class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        res = []
        val = 0
        for i in range(len(nums)):
            val += nums[i]
            res.append(val)
        
        return res