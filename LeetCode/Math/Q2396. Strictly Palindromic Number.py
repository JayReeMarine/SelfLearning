#https://leetcode.com/problems/strictly-palindromic-number/description/

class Solution:
    def isStrictlyPalindromic(self, n: int) -> bool:
        def toBase(n, base):
            digits = []
            while n > 0:
                digits.append(str(n%base))
                n //= base
            return ''.join(digits[::-1]) if digits else "0"
        
        for i in range(2, n-1):
            digit = toBase(n,i)
            l, r = 0, len(digit) -1
            while l < r:
                if digit[l] != digit[r]:
                    return False
                l += 1
                r -= 1
        
        return True