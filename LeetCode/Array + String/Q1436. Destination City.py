#https://leetcode.com/problems/destination-city/description/

from typing import List

class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        start_point = set()
        for i in range(len(paths)):
            start_point.add(paths[i][0])

        for i in range(len(paths)):
            if paths[i][1] not in start_point:
                return paths[i][1]
