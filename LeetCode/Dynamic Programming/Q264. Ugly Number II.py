#https://leetcode.com/problems/ugly-number-ii/description/

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n == 1:
            return 1
        val2 = 0
        val3 = 0
        val5 = 0

        ugly = [1]
        while len(ugly) < n:
            next2 = ugly[val2] * 2
            next3 = ugly[val3] * 3
            next5 = ugly[val5] * 5
            minVal = min(next2, next3, next5)
            ugly.append(minVal)
            if minVal == next2:
                val2 += 1
            if minVal == next3:
                val3 += 1
            if minVal == next5:
                val5 += 1

        return ugly[-1]
