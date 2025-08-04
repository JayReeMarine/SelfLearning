#https://leetcode.com/problems/count-good-numbers/description/

class Solution:
    def countGoodNumbers(self, n: int) -> int:
        MOD = (10**9 + 7)
        if n % 2:
            odd, even = n//2, n//2 + 1
        else:
            odd, even = n//2, n//2

        if odd:
            return (pow(5, even, MOD) * pow(4, odd, MOD)) % MOD
        else:
            return pow(5, even, MOD) % MOD


        