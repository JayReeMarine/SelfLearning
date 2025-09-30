#https://leetcode.com/problems/island-perimeter/description/

from typing import List

class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        res = 0
        rows, cols = len(grid), len(grid[0])
        
        def in_bounds(r,c):
            return 0<= r <rows and 0<= c < cols

        dir = [(0,-1), (0,1), (1,0), (-1, 0)]
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1:
                    count = 4
                    for dr, dc in dir:
                        nr, nc = r + dr, c + dc
                        if in_bounds(nr, nc) and grid[nr][nc] == 1:
                            count -= 1
                    res += count
        
        return res
                    