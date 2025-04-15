
#https://leetcode.com/problems/happy-number/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()
        
        seen.add(n)

        while 1 not in seen:
            n  = self.sumOfSquare(n)
            if n in seen:
                return False
            seen.add(n)        
        return True
    
    def sumOfSquare(self,n):
        total = 0
        while n >0:
            digit = n % 10
            total += digit *digit
            n = n//10
        return total