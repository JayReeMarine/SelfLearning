#https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

from typing import List

class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        # method 1
        # res = 0

        # for i in range(len(grid)):
        #     n = 0
        #     while n < len(grid[i]):
        #         if grid[i][n] < 0:
        #             res += len(grid[i]) - n 
        #             break
        #         else:
        #             n += 1

        # return res 

        #method 2

        # def first_negative_index(row):
        #     l, r = 0, len(row) - 1
        #     while l <= r:
        #         mid = (l + r) // 2
        #         if row[mid] < 0:
        #             r = mid - 1
        #         else:
        #             l = mid + 1
        #     return l  

        # total = 0

        # for row in grid:
        #     idx = first_negative_index(row)
        #     total += len(row) - idx
        # return total

        #method 3
        m, n = len(grid), len(grid[0])
        row , col = 0, len(grid[0]) - 1
        res = 0

        while row < m and col >= 0:
            if grid[row][col] < 0:
                res += (m - row)
                col -= 1
            else:
                row += 1
        return res
