#https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/

from typing import List

class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        res = 0
        for num in nums:
            if num % 3 != 0:
                res += 1

        return res
            