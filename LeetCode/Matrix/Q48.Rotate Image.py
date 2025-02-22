#https://leetcode.com/problems/rotate-image/?envType=study-plan-v2&envId=top-interview-150
from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        # Step 1: Transpose the matrix (swap matrix[i][j] with matrix[j][i])
        for i in range(len(matrix)):
            for j in range(i,len(matrix)):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j] 

        # Step 2: Reverse each row
        for i in range(len(matrix)):
            matrix[i].reverse()