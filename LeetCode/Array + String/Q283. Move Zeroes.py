#https://leetcode.com/problems/move-zeroes/description/

from collections import List 

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        non_zero = 0

        for i in range(len(nums)):
            if nums[i] != 0:
                nums[non_zero], nums[i] = nums[i], nums[non_zero]
                non_zero +=1
            