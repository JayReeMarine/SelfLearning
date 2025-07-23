#https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/

class Solution:
    def makeFancyString(self, s: str) -> str:
        count = 0
        prev = ""
        res = []
        for i in range(len(s)):
            if s[i] == prev:
                count += 1
            else:
                count = 1
                prev = s[i]
            
            if count < 3:
                res.append(s[i])
            

        
        return ''.join(res)