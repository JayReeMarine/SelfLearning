#https://leetcode.com/problems/number-of-1-bits/description/

class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 1

        while n > 1:
            if n %2 == 1:
                count +=1
            n = n //2

        return count