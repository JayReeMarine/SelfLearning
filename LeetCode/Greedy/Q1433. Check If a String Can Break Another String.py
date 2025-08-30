#https://leetcode.com/problems/check-if-a-string-can-break-another-string/description/

class Solution:
    def checkIfCanBreak(self, s1: str, s2: str) -> bool:
        s1 = sorted(list(s1))
        s2 = sorted(list(s2))

        big = "" #left or right

        for i in range(len(s1)):
            if big == "":
                if s1[i] == s2[i]:
                    continue
                big = "left" if s1[i] > s2[i] else "right"
            else:
                if big == "left" and s1[i] < s2[i]:
                    return False
                elif big == "right" and s1[i] > s2[i]:
                    return False
        
        return True