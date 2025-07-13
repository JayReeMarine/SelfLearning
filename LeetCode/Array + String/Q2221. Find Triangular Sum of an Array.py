#https://leetcode.com/problems/find-triangular-sum-of-an-array/description/
from typing import List

class Solution:
    def triangularSum(self, nums: List[int]) -> int:
        while len(nums) > 1:
            for i in range(0, len(nums) -1):
                nums[i] = (nums[i] + nums[i+1]) % 10
            del nums[len(nums)-1]
        
        return nums[0]

