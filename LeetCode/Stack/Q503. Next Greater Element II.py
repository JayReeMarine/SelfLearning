#https://leetcode.com/problems/next-greater-element-ii/

from typing import List

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        res = [-1] * len(nums)
        stack = []
        
        for i in range(len(nums)*2):
            cur = nums[i % len(nums)]

            while stack and nums[stack[-1]] < cur:
                res[stack.pop()] = cur
            if i < len(nums):
                stack.append(i)

        return res

