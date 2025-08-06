#https://leetcode.com/problems/fruit-into-baskets/description/

from typing import List
from collections import defaultdict

class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        counter = defaultdict(int)
        left = 0
        max_num = 0

        for right in range(len(fruits)):
            counter[fruits[right]] += 1

            while len(counter) > 2:
                counter[fruits[left]] -= 1
                if counter[fruits[left]] == 0:
                    del counter[fruits[left]]
                left += 1
        
            max_num = max(max_num, right - left + 1)
            # if fruits[right] not in counter and len(counter) < 2:
            #     counter[fruits[right]] += 1
            # elif fruits[right] not in counter and len(counter) == 2:
            #     counter[fruits[right]] += 1
            #     while len(counter) > 2:
            #         counter[fruits[left]] -= 1
            #         if counter[fruits[left]] == 0:
            #             del counter[fruits[left]]
            #         left += 1         
            # max_num = max(max_num, right - left + 1)

        return max_num 

