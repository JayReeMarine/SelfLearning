from collections import List

class Solution:
    def minOperations(self, nums: List[int]) -> int:
        res = 0
        for i in range(1, len(nums)):
            if nums[i] <= nums[i - 1]:
                diff = nums[i - 1] - nums[i] + 1
                nums[i] += diff
                res += diff
        return res