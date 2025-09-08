#https://leetcode.com/problems/non-decreasing-subsequences/

from typing import List

class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        N = len(nums)
        ans = set()

        def find(index, last, current):
            if index == N:
                if len(current) >= 2:
                    ans.add(tuple(current))
                return
            if nums[index] >= last:
                current.append(nums[index])
                find(index + 1, nums[index], current)
                current.pop()
            find(index +1, last, current)
    
        find(0, -10000, [])
        return [list(t) for t in ans]