#https://leetcode.com/problems/valid-sudoku/description/?envType=study-plan-v2&envId=top-interview-150
from typing import List

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        #step one: check the row 
        for row in range(9):
            seen = set()
            for num in board[row]:
                if num != ".":
                    if num in seen:
                        return False
                    seen.add(num)

        #step two: check the vertical
        for col in range(9):
            seen = set()
            for row in range(9):
                num = board[row][col]
                if num!= ".":
                    if num in seen:
                        return False
                    seen.add(num)


        #step three: check the sub-square
        for i in range(0,9,3):
            for j in range(0,9,3):
                seen = set()
                for row in range(3):
                    for ver in range(3):
                        num = board[i+row][j+ver]
                        if num!= '.':
                            if num in seen:
                                return False
                            seen.add(num)

        return True