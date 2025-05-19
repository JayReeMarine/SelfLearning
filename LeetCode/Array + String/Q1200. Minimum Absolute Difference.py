#https://leetcode.com/problems/minimum-absolute-difference/description/
from typing import List

class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        # arr = sorted(arr)
        # min_val = float('inf')

        # for i in range(0,len(arr)-1):
        #     val = arr[i+1] - arr[i]
        #     if val < min_val:
        #         min_val = val

        # res = []

        # for i in range(0,len(arr)-1):
        #     if arr[i+1] - arr[i] == min_val:
        #         res.append([arr[i],arr[i+1]])

        # return res

        arr.sort()
        res = []
        min_diff = float('inf')

        for i in range(len(arr) - 1):
            diff = arr[i + 1] - arr[i]
            if diff < min_diff:
                min_diff = diff
                res = [[arr[i], arr[i + 1]]]
            elif diff == min_diff:
                res.append([arr[i], arr[i + 1]])

        return res