#https://leetcode.com/problems/ant-on-the-boundary/description/

from typing import List

class Solution:
    def returnToBoundaryCount(self, nums: List[int]) -> int:
        res = 0
        cur = 0
        for i in range(len(nums)):
            cur += nums[i]
            if cur == 0:
                res += 1
        
        return res