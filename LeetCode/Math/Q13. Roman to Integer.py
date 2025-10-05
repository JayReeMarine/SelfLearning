#https://leetcode.com/problems/roman-to-integer/description/

class Solution:
    def romanToInt(self, s: str) -> int:
        symbol = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }

        res = 0
        for i in range(len(s)):
            if (i+1 < len(s) )and (symbol[s[i]] < symbol[s[i+1]]):
                res -= symbol[s[i]]
            else:
                res += symbol[s[i]]
        
        return res

