#https://leetcode.com/problems/defuse-the-bomb/description/

from typing import List
class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        #initalise variables
        n = len(code)
        result = [0] * n

        #base case
        if k == 0:
            return result
        
        for i in range(n):
            total = 0
            if k >0:
                for j in range(1, k+1):
                    total += code[(i+j) % n]
            elif k <0:
                for j in range(1, abs(k)+1):
                    total += code[(i-j) % n]

            result[i] = total

        return result