#https://leetcode.com/problems/find-unique-binary-string/description/

from typing import List

class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        # binary = len(nums[0])

        # for i in range(2 ** binary):
        #     num = format(i, f'0{binary}b')

        #     if num not in nums:
        #         return num

        binary = len(nums[0])
        res = ""
        for i in range(binary):
            bit = '1' if nums[i][i] == '0' else '0'
            res += bit
        
        return res
