#https://leetcode.com/problems/brick-wall/description/
from collections import defaultdict
from typing import List

class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        edgeCount = defaultdict(int)

        for row in wall:
            total = 0
            for i in range(len(row)-1):
                total += row[i]
                edgeCount[total] += 1

        return len(wall) - max(edgeCount.values(), default = 0)


        # sumWall = []
        # for i in range(len(wall)):
        #     sub = []
        #     amount = 0
        #     for j in range(len(wall[i]) - 1):
        #         amount += wall[i][j]
        #         sub.append(amount)
        #     sumWall.append(sub)

        # res = len(wall)
        # for i in range(0, len(sumWall) - 1):
        #     cross = 0
        #     for j in range(len(sumWall)):
        #         if i not in sumWall[j]:
        #             cross += 1
        #     if cross != 0:
        #         res = min(res,cross)

        # return res 