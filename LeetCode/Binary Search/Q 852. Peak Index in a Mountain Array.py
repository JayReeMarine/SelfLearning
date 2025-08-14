#https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

from typing import List

class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        low = 0
        high = len(arr) - 1

        while low < high:
            mid = (low+high)//2
            if arr[mid+1] < arr[mid]:
                high = mid
            else:
                low = mid + 1
        
        return high
         