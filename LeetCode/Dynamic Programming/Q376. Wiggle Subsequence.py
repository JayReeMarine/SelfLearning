#https://leetcode.com/problems/wiggle-subsequence/description/

from typing import List

class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        # wiggle = []
        # seq = 2
        
        # if len(set(nums)) == 1:
        #     return 1

        # for i in range(len(nums) - 1):
        #     diff = nums[i+1] - nums[i]

        #     if diff == 0:
        #         continue

        #     if wiggle:
        #         if (wiggle[-1] > 0 and diff < 0) or (wiggle[-1] < 0 and diff > 0):
        #             seq += 1
        #     wiggle.append(diff)

        # return seq

        if len(nums) < 2:
            return len(nums)
        
        prev_diff = nums[1] - nums[0]
        count = 1 if prev_diff == 0 else 2

        for i in range(2, len(nums)):
            diff = nums[i] - nums[i - 1]

            if (diff > 0 and prev_diff <= 0) or (diff < 0 and prev_diff >= 0):
                count += 1
                prev_diff = diff
        
        return count