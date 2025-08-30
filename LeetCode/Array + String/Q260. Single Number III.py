#https://leetcode.com/problems/single-number-iii/description/

from typing import List

class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        res = set()

        for num in nums:
            if num in res:
                res.remove(num)
            else:
                res.add(num)

        return list(res)