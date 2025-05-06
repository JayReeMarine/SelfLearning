#https://leetcode.com/problems/find-the-pivot-integer/description/

class Solution:
    def pivotInteger(self, n: int) -> int:
        total = n * (n + 1) // 2  
        
        left_sum = 0
        for x in range(1, n + 1):
            left_sum += x
            right_sum = total - (x - 1) * x // 2 
            
            if left_sum == right_sum:
                return x  
        
        return -1  