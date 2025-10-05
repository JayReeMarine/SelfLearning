#https://leetcode.com/problems/integer-to-roman/description/

class Solution:
    def intToRoman(self, num: int) -> str:
        valueToSymbol =[
            (1000, 'M'),
            (900, "CM"),
            (500, "D"),
            (400, "CD"),
            (100, "C"),
            (90, "XC"),
            (50, "L"),
            (40, "XL"),
            (10, "X"),
            (9, "IX"),
            (5, "V"),
            (4, "IV"),
            (1, "I")
        ]
        res = ""
        for i in range(len(valueToSymbol)):
            if num == 0:
                return res
            while valueToSymbol[i][0] <= num:
                num -= valueToSymbol[i][0]
                res += valueToSymbol[i][1]
        
        return res