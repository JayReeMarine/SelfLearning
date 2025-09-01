#https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/description/

from typing import List

class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        minDist = float('inf')
        ans = -1  

        for i, (ix, iy) in enumerate(points):
            if ix == x or iy == y:
                currDist = abs(ix - x) + abs(iy - y)
                if currDist < minDist:
                    minDist = currDist
                    ans = i

        return ans
