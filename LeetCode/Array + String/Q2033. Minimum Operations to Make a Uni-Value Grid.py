#https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/

import numpy as np
from collections import List

class Solution:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        grid = np.sort(np.array(grid).flatten())
        median = int(grid[len(grid)//2])
        res = 0

        for i in grid:
            diff = abs(int(i) - median)
            if diff % x != 0:
                return -1
            res += diff // x
        
        return int(res)

        


