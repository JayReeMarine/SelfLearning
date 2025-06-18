#https://leetcode.com/problems/third-maximum-number/description/

from collections import List


class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        # origin = set(nums)
        # nums = set(nums)
        # if len(origin) >= 3:
        #     for i in range(2):
        #         nums.remove(max(nums))

        # return max(nums) if len(origin) >= 3 else max(origin)

        first = second = third = float('-inf')
        
        for num in nums:
            if num == first or num == second or num == third:
                continue  
            
            if num > first:
                first, second, third = num, first, second
            elif num > second:
                second, third = num, second
            elif num > third:
                third = num
        
        return third if third != float('-inf') else first
