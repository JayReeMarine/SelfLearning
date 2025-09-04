#https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

from typing import List

class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        res = []
        seen = set()
        for num in nums:
            if num not in seen:
                seen.add(num)
            else:
                res.append(num)
        
        return res
