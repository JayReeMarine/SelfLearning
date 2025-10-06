#https://leetcode.com/problems/power-of-two/description/

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        # while n > 1 and n % 2 == 0:
        #     n //= 2
        # return n == 1

        return n >0 and 2**31 % n == 0