from collections import List

class Solution:
    def missingInteger(self, nums: List[int]) -> int:
        
        def getMaxSum(nums):
            sequence_sum = nums[0]
            for i in range(1, len(nums)):
                if nums[i] == nums[i-1] + 1:
                    sequence_sum += nums[i]
                else:
                    break
            return sequence_sum

        res = getMaxSum(nums)
        while res in set(nums):
            res += 1
        
        return res