#https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/


class Solution:
    def maxDepth(self, s: str) -> int:
        max_depth = 0
        depth = 0
        for i in s:
            if i == "(":
                depth +=1
                if max_depth < depth:
                    max_depth = depth
            elif i == ")":
                depth -=1
        
        return max_depth
    