#https://leetcode.com/problems/sum-of-squares-of-special-elements/description/

from typing import List

class Solution:
    def sumOfSquares(self, nums: List[int]) -> int:
        n = len(nums)
        res = 0
        for i in range(1,n+1):
            if n % i == 0:
                res += nums[i-1]**2
        return res
