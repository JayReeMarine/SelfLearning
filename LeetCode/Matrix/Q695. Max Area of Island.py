#https://leetcode.com/problems/max-area-of-island/description/

from typing import List

class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])

        visited = [[False] * cols for _ in range(rows)]
        
        dir = [(0,-1), (0,1), (1,0), (-1, 0)]

        def in_bounds(r,c):
            return 0<= r <rows and 0<= c < cols
        
        def dfs_iter(start_r, start_c):
            stack = [(start_r, start_c)]
            visited[start_r][start_c] = True
            area = 0

            while stack:
                r,c = stack.pop()
                area += 1
                for dr, dc in dir:
                    nr, nc = r + dr, c + dc
                    if in_bounds(nr,nc) and not visited[nr][nc] and grid[nr][nc] == 1:
                        visited[nr][nc] = True
                        stack.append((nr,nc))
            return area


        res = 0
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1 and not visited[r][c]:
                    res = max(res, dfs_iter(r, c))
        
        return res