#https://leetcode.com/problems/different-ways-to-add-parentheses/description/

from typing import List
from functools import lru_cache

class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        @lru_cache(maxsize=None)
        def compute_all_ways(sub_exp):
            if sub_exp.isdigit():
                return [int(sub_exp)]
            result = []
            for idx, char in enumerate(sub_exp):
                if char in '-+*':
                    left_results = compute_all_ways(sub_exp[:idx])
                    right_results = compute_all_ways(sub_exp[idx + 1:])
                    for left_val in left_results:
                        for right_val in right_results:
                            if char == "-":
                                result.append(left_val - right_val)
                            elif char == "+":
                                result.append(left_val + right_val)
                            else:
                                result.append(left_val * right_val)
            return result
        return compute_all_ways(expression)