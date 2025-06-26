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
        
        # prev_run = 0  
        # cur_run = 1   
        # res = 0

        # for i in range(1, len(s)):
        #     if s[i] == s[i - 1]:
        #         cur_run += 1
        #     else:
        #         res += min(prev_run, cur_run)
        #         prev_run = cur_run
        #         cur_run = 1

        # res += min(prev_run, cur_run)  
        # return res

        
