#https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/description/

from collections import List


class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        total = sum(nums)
        remainder = total % k
        return 0 if remainder == 0 else remainder