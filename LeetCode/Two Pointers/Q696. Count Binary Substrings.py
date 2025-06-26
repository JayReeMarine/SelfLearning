#https://leetcode.com/problems/count-binary-substrings/description/

class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        res = 0
        group = []
        prev = '-1'
        freq = 0
        for num in s:
            cur = num
            if prev != cur:
                group.append(freq)
                freq = 1
            else:
                freq += 1
            prev = cur
        group.append(freq)

        for i in range(0,len(group)-1):
            res += min(group[i],group[i+1])
        
        return res
        
