#https://leetcode.com/problems/zigzag-conversion/description/

class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1 or numRows >= len(s):
            return s
        rows = [""] * numRows
        r = 0
        status = "down"
        res = ""

        for ch in s:
            rows[r] += ch
            if r == 0:
                status = "down"
            elif r == numRows - 1:
                status = "up"
            if status == "down":
                r += 1
            else:
                r -= 1
        for i in range(numRows):
            res += rows[i]
        
        return res
