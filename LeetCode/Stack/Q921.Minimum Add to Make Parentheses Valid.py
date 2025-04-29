#https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        q = deque()
        left = 0

        for ch in s:
            if ch == "(":
                q.append(ch)
            else:
                if len(q) == 0:
                    left +=1
                else:
                    q.pop()
        
        return left + len(q)
                    