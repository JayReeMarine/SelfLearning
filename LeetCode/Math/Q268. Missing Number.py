#https://leetcode.com/problems/missing-number/?envType=problem-list-v2&envId=sorting

from typing import List

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        total = (n * (n+1)) //2
        actual_total = sum(nums)
        return total - actual_total