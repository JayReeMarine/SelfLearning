from collections import List

class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        res = 0
        for i in range(len(nums)):
            if nums[i] < k:
                res += 1
        
        return res