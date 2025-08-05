#https://leetcode.com/problems/maximum-erasure-value/description/
from typing import List

class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        seen = set()
        left = 0
        max_sum = 0
        cur_sum = 0

        for right in range(len(nums)):
            while nums[right] in seen:
                seen.remove(nums[left])
                cur_sum -= nums[left]
                left += 1

            seen.add(nums[right])
            cur_sum += nums[right]
            max_sum = max(max_sum,cur_sum)
        
        return max_sum

