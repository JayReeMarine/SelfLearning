#https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/

from typing import List


class Solution:
    def smallestIndex(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            sum = 0
            for j in str(nums[i]):
                sum += int(j)

            if sum == i:
                return i
        
        return -1