#https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/


class Solution:
    def makeFancyString(self, s: str) -> str:
        # s = list(s.strip())
        # char = ""
        # seq = 0
        # pop_list= []
        # for i in range(len(s)-1,-1,-1):
        #     if s[i] != char:
        #         char = s[i]
        #         seq = 1
        #     else:
        #         seq +=1
            
        #     if seq >= 3:
        #         s.pop(i)

        # return "".join(s)
        res =""
        for ch in s:
            if len(res) >= 2 and res[-1] == res[-2] == ch:
                continue
            else:
                res += ch
        return res