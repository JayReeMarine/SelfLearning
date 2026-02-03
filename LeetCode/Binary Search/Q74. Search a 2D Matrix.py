#https://leetcode.com/problems/search-a-2d-matrix/description/

from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        #find row
        l = 0
        h = len(matrix) - 1
        while l <= h:
            r = (l+h) // 2
            if matrix[r][0] > target:
                h = r - 1
            elif matrix[r][-1] < target:
                l = r + 1
            else:
                break
        
        if l > h:
            return False
        
        #binary search on row
        l = 0
        h = len(matrix[r]) - 1
        while l <= h:
            mid = (l + h) // 2
            print(mid)
            if matrix[r][mid] < target:
                l = mid + 1
            elif matrix[r][mid] > target:
                h = mid - 1
            else:
                return True
        
        return False



            
