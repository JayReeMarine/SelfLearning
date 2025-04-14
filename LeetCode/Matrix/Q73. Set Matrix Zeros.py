#https://leetcode.com/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-interview-150

from typing import List

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        raw = []
        column = []

        #Record zero index into list
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j] == 0:
                    raw.append(i)
                    column.append(j)

        #traverse each index and replace to zero
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if i in raw or j in column:
                    matrix[i][j] = 0



Solution = Solution()
a = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Solution.setZeroes(a)
print(a)