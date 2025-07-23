#https://leetcode.com/problems/keyboard-row/

from typing import List

class Solution:
    def findWords(self, words: List[str]) -> List[str]:
        res = []
        first = "qwertyuiop"
        second = "asdfghjkl"
        third = "zxcvbnm"

        available = True
        for i in range(len(words)):
            prev = ""
            curr = ""

            for j in range(len(words[i])):
                word = words[i][j].lower()
                if word in first:
                    curr = first
                elif word in second:
                    curr = second
                elif word in third:
                    curr = third

                if prev == "":
                    prev = curr
                elif prev != curr:
                    available = False
            
            if available:
                res.append(words[i])
            else:
                available = True
        return res
                
                


