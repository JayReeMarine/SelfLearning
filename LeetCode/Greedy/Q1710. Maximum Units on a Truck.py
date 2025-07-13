#https://leetcode.com/problems/maximum-units-on-a-truck/
from typing import List

class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        sortedBox = sorted(boxTypes, key=lambda boxUnit: boxUnit[1], reverse = True)
        res = 0

        for i in range(len(sortedBox)):
            if truckSize == 0:
                return res

            if truckSize >= sortedBox[i][0]:
                res += sortedBox[i][0] * sortedBox[i][1]
                truckSize -= sortedBox[i][0]
            else:
                res += truckSize * sortedBox[i][1]
                truckSize = 0
            
        return res