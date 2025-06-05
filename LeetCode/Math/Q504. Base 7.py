#https://leetcode.com/problems/base-7/

class Solution:
    def convertToBase7(self, num: int) -> str:
        if num == 0:
            return "0"
        negative = num < 0

        num = abs(num)
        res = ""

        while num > 0:
            res = str(num % 7) + res
            num  = num //7
        
        return "-" + res if negative else res
    