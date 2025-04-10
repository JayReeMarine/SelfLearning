#https://leetcode.com/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150
from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        
        counter = defaultdict(list)

        for i in strs:
        
            sortedStr = ''.join(sorted(i))
            if sortedStr in counter:
                counter[sortedStr].append(i)
            else:
                counter[sortedStr] = [i]
        

        return list(counter.values())


   

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