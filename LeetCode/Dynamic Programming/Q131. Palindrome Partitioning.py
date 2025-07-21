#https://leetcode.com/problems/palindrome-partitioning/description/

from collections import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        part = []
        
        def is_Palindrome(s, left, right):
            # while left >= 0 and right < len(s):
            #     if s[left] == s[right]:
            #         left -= 1
            #         right += 1
            #     else:
            #         return False
            # return True
            while left < right:
                if s[left] != s[right]:
                    return False
                left, right = left + 1, right - 1
            return True

        def dfs(i):
            if i >= len(s):
                res.append(part.copy())
                return
            for j in range(i, len(s)):
                if is_Palindrome(s, i, j):
                    part.append(s[i:j+1])
                    dfs(j + 1)
                    part.pop()
        dfs(0)
        return res


