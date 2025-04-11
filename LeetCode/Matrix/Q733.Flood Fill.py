#https://leetcode.com/problems/flood-fill/

from collections import deque  
from typing import List

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        q = deque()
        q.append([sr,sc])
        
        target = image[sr][sc]
        image[sr][sc] = color

        direction = [[-1,0], [1,0], [0,-1], [0,1]]

        while q:
            for i in range(len(q)):
                r, c = q.pop()
                for dr, dc in direction:
                    row , col = r + dr, c + dc

                    if (row<0 or row == len(image) or col<0 or col == len(image[0]) or image[row][col] == color):
                        continue
                    elif image[row][col] == target:
                        image[row][col] = color
                        q.append([row,col])
                    else:
                        continue
        
        return image

