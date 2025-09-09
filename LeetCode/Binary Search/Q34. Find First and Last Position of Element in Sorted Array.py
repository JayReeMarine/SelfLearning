#https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1,-1]
        n = len(nums)

        def lower_bound(x):
            l, r = 0, n
            while l < r:
                m = (l + r) // 2
                if nums[m] < x:
                    l = m + 1
                else:
                    r = m
            return l
        
        def upper_bound(x):
            l, r = 0, n
            while l < r:
                m = (l + r) // 2
                if nums[m] <= x:
                    l = m + 1
                else:
                    r = m
            return l
        
        left = lower_bound(target)
        if left == n or nums[left] != target:
            return [-1,-1]
        
        right = upper_bound(target) -1
        return [left, right]