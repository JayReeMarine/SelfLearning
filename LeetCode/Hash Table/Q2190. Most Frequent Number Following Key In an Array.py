#https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/description/

from typing import List
from collections import Counter

class Solution:
    def mostFrequent(self, nums: List[int], key: int) -> int:
        freq = Counter()
        for i in range(len(nums) - 1):
            if nums[i] == key:
                freq[nums[i+1]] += 1
        
        return max(freq, key=freq.get)