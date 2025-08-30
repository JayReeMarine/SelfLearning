#https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/description/

from typing import List

class Solution:
    def findColumnWidth(self, grid: List[List[int]]) -> List[int]:
        # res = []

        # for n in range(len(grid[0])):
        #     cur = 0
        #     for m in range(len(grid)):
        #         cur = max(cur, len(str(grid[m][n])))
            
        #     res.append(cur)
        
        # return res
        m, n = len(grid), len(grid[0])
        widths = [0] * n
        for r in range(m):
            row = grid[r]  
            for c in range(n):
                w = len(str(row[c]))
                if w > widths[c]:
                    widths[c] = w
        return widths
            
