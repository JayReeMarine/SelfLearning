#https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/

from typing import List

class Solution:
    def countPairs(self, nums: List[int], target: int) -> int:
        nums.sort()
        left, right = 0, len(nums) - 1

        res = 0
        while left < right:
            if nums[left] + nums[right] < target:
                res += right - left
                left += 1
            else:
                right -= 1
        return res


        # res = 0

        # for i in range(len(nums)):
        #     for j in range(i+1, len(nums)):
        #         if nums[i] + nums[j] < target:
        #             res +=1
        
        # return res