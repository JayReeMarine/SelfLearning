#https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/description/

from typing import List

class Solution:
    def countDistinctIntegers(self, nums: List[int]) -> int:
        res = set(nums)

        for i in range(len(nums)):
            num = int(str(nums[i])[::-1])
            if num not in res:
                res.add(num)
        
        return len(res)