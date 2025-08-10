#https://leetcode.com/problems/process-string-with-special-operations-i/description/

class Solution:
    def processStr(self, s: str) -> str:
        res = []
        for i in s:
            if i == "*":
                # if len(res) != 0:
                #     res.pop(-1)
                if res:
                    res.pop()
            elif i == "#":
                # for j in range(len(res)):
                #     res.append(res[j])
                res.extend(res.copy())
            elif i == "%":
                # res = res[::-1]  
                res.reverse()          
            else:
                res.append(i)
        
        return ''.join(res)
