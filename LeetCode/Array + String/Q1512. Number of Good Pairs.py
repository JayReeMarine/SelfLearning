#https://leetcode.com/problems/number-of-good-pairs/description/
from typing import List
class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        pair = 0

        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] == nums[j]:
                    pair +=1
        
        return pair