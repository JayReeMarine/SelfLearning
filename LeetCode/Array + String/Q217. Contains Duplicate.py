import collections
from typing import List

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        # cnt = Counter(nums)
        # for key, value in enumerate(cnt):
        #     if cnt[value] > 1:
        #         return True
        
        # return False
        seen = set()
        for num in nums:
            if num in seen:
                return True
            seen.add(num)
        return False