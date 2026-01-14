#https://leetcode.com/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150
from collections import defaultdict
from typing import List
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # cnt = defaultdict(list)

        # for letter in strs:
        #     sortedS = ''.join(sorted(letter))
        #     cnt[sortedS].append(letter)
        
        # return list(cnt.values())

        cnt = defaultdict(list)

        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            cnt[tuple(count)].append(s)
        return list(cnt.values())


   

Solution = Solution()
print(Solution.groupAnagrams(["eat","tea","tan","ate","nat","bat"]))  # [["bat"],["nat","tan"],["ate","eat","tea"]]

print(Solution.groupAnagrams([""]))  # [[""]]

print(Solution.groupAnagrams(["a"]))  # [["a"]]


"""Approach
take out string
char array
sort it
convert to string
use this string as a key
then push all the related element to key
"""