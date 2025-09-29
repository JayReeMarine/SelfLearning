#https://leetcode.com/problems/restore-finishing-order/description/

from typing import List

class Solution:
    def recoverOrder(self, order: List[int], friends: List[int]) -> List[int]:
        friends = set(friends)
        res = []
        for i in order:
            if i in friends:
                res.append(i)


        return res