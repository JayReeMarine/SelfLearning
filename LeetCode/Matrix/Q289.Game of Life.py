#https://leetcode.com/problems/game-of-life/?envType=study-plan-v2&envId=top-interview-150
from typing import List


from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        directions = [(-1,-1), (-1,0), (-1,1),
                      (0,-1),         (0,1),
                      (1,-1), (1,0), (1,1)]

        # Step 1: Mark changes with temporary values
        for i in range(len(board)):
            for j in range(len(board[i])):
                oneNum = 0  # Count live neighbors

                for dr, dc in directions:
                    r, c = i + dr, j + dc
                    if 0 <= r < len(board) and 0 <= c < len(board[i]) and (board[r][c] == 1 or board[r][c] == 2):
                        oneNum += 1

                # Apply rules with temporary markers:
                if board[i][j] == 1 and (oneNum < 2 or oneNum > 3):
                    board[i][j] = 2  

                if board[i][j] == 0 and oneNum == 3:
                    board[i][j] = -1  

        # Step 2: Finalize board updates
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] == 2:
                    board[i][j] = 0  # Dead
                elif board[i][j] == -1:
                    board[i][j] = 1  # Alive


# Example Test Case
Solution = Solution()
a = [[0,1,0], [0,0,1], [1,1,1], [0,0,0]]
Solution.gameOfLife(a)
print(a)  # Expected Output: [[0,0,0], [1,0,1], [0,1,1], [0,1,0]]

