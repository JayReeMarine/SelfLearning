#https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/description/

from typing import List

class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        bucket = [[] for _ in range(max(groupSizes))]
        res = []
        for i in range(len(groupSizes)):
            bucket[groupSizes[i]-1].append(i)
            if len(bucket[groupSizes[i]-1]) == groupSizes[i]:
                res.append(bucket[groupSizes[i]-1])
                bucket[groupSizes[i]-1] = []
            
        
        return res
