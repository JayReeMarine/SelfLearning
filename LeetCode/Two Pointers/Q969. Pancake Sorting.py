#https://leetcode.com/problems/pancake-sorting/description/
from typing import List

class Solution:
    def pancakeSort(self, arr: List[int]) -> List[int]:
        res = []

        for size in range(len(arr),1,-1):

            max_idx = arr.index(size)
            if max_idx == size -1 :
                continue
            
            if max_idx != 0:
                res.append(max_idx + 1)
                arr[:max_idx+1] = arr[:max_idx+1][::-1]

            res.append(size)
            arr[:size] = arr[:size][::-1]
        print(res)
        return res
            



