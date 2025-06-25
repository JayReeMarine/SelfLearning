#https://leetcode.com/problems/a-number-after-a-double-reversal/

class Solution:
    def isSameAfterReversals(self, num: int) -> bool:
        if num == 0:
            return True
        num = str(num)
        return True if num[-1] != '0' else False