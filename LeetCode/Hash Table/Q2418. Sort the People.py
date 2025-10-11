#https://leetcode.com/problems/sort-the-people/description/

from typing import List

class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        # res = []

        # while names:
        #     maxHeight = max(heights)
        #     maxIndex = heights.index(maxHeight)
        #     res.append(names[maxIndex])
        #     names.pop(maxIndex)
        #     heights.pop(maxIndex

        # return res
        height_to_name = {}
        for h, n in zip(heights, names):
            height_to_name[h] = n
        
        res = []
        #time complexity: nlogn
        for h in reversed(sorted(heights)):
            res.append(height_to_name[h])
        
        return res

        