#https://leetcode.com/problems/product-of-array-except-self/description/

from typing import List
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [1]
        right = 1
        
        for i in range(len(nums) -1):
            res.append(res[-1] * nums[i])

        for i in range(len(nums)-1,-1,-1):
            res[i] *= right
            right *= nums[i]
        
        return res