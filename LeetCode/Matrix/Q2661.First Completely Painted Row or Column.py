#https://leetcode.com/problems/first-completely-painted-row-or-column/

class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        res = float('inf')
        col = [0] * len(mat[0])
        row = [0] * len(mat)

        pos =  {}
        for r in range(len(mat)):
            for c in range(len(mat[r])):
                pos[mat[r][c]] = (r,c)

        for i, num in enumerate(arr):
            r , c = pos[num]
            col[c] += 1
            row[r] += 1
            if col[c] == len(mat) or row[r] == len(mat[0]):
                return i
        


