#https://leetcode.com/problems/number-of-islands/description/

from collections import deque
from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        q = deque()
        island = 0

        direction = [[-1,0], [1,0], [0,1], [0,-1]]

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1" and [i,j] not in q:
                    island += 1
                    q.append([i, j])
                    grid[i][j] = "0"

                    while q:
                        r, c = q.popleft()
                        for dr, dc in direction:
                            row, col = r + dr, c + dc
                            if (0 <= row < len(grid) and 0 <= col < len(grid[0]) and grid[row][col] == "1"):
                                q.append([row, col])
                                grid[row][col] = "0"
        
        return island