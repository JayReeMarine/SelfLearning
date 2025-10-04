#https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/

from typing import List

class Solution:
    def minMoves(self, nums: List[int]) -> int:
        # if len(set(nums)) == 1:
        #     return 0

        # res = 0
        # minVal = min(nums)
        # for num in nums:
        #     res += (num-minVal)
        
        # return res
        if not nums:
            return 0
        
        min_val = min(nums)
        total_sum = sum(nums)
        return total_sum - min_val * len(nums)