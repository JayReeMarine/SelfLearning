import heapq
from collections import List

class Solution:
    def numberGame(self, nums: List[int]) -> List[int]:
        heapq.heapify(nums)
        arr = []
        while nums:
            alice = heapq.heappop(nums)
            bob = heapq.heappop(nums)
            arr.append(bob)
            arr.append(alice)
        
        return arr
        # nums.sort()  # O(n log n)
        # arr = []
        # for i in range(0, len(nums), 2):
        #     arr.append(nums[i + 1])  # Bob
        #     arr.append(nums[i])      # Alice
        # return arr
