#https://leetcode.com/problems/generate-parentheses/description/

from typing import List
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        output = []

        def generate (curr,left ,right):
            if left == n and right == n:
                output.append(curr)
                return
            
            if left < n:
                generate(curr + '(', left + 1, right)
            
            if right < left:
                generate(curr + ')', left, right + 1)
        

        generate("",0,0)


        return output
    
    
