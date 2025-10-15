#https://leetcode.com/problems/ugly-number/description/

class Solution:
    def isUgly(self, n: int) -> bool:
        # if n <= 0:
        #     return False
        # if n == 1:
        #     return True

        # for i in [2,3,5]:
        #     while n % i == 0:
        #         n //= i

        # return n == 1

        if n <= 0:
            return False
        if n == 1:
            return True

        # Remove all factors of 2, then 3, then 5.
        while n % 2 == 0:
            n //= 2
        while n % 3 == 0:
            n //= 3
        while n % 5 == 0:
            n //= 5

        return n == 1