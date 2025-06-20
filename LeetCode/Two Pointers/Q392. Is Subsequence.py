#https://leetcode.com/problems/is-subsequence/description/

class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        seq = 0
        
        if len(t) == 0 and len(s) == 0:
            return True

        for i in t:
            if seq == len(s):
                return True
            elif i == s[seq] and seq < len(s):
                seq += 1
        
        return seq == len(s)
