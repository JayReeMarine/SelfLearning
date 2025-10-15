#https://leetcode.com/problems/count-primes/description/

class Solution:
    def countPrimes(self, n: int) -> int:
        
        if n < 3:
            return 0
        prime = [True] * (n )
        prime[0], prime[1] = False , False
        p = 2
        while p * p <= n: # O(sqrt(n))
            if prime[p]:
                for i in range(p * p, n, p): # O(n long log n)
                    prime[i] = False
            p += 1

        return prime.count(True)
