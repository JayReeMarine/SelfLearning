#https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/
from typing import List

class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        count = 0

        for i in range(len(words)):
            for j in range(i+1, len(words)):
                if words[j].startswith(words[i]) and words[j][::-1].startswith(words[i][::-1]):
                    count+=1
        
        return count
   