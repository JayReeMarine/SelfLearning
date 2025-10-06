#https://leetcode.com/problems/power-of-three/description/

class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        # if n <= 0:
        #     return False
        
        # if 1162261467 % n == 0:
        #     return True
        # return False
        while n > 1 and n % 3 == 0:
            n //= 3
        return n == 1