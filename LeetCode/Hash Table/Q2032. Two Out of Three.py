#https://leetcode.com/problems/two-out-of-three/

from collections import List , Counter

class Solution:
    def twoOutOfThree(self, nums1: List[int], nums2: List[int], nums3: List[int]) -> List[int]:
        count = Counter([])

        count.update(set(nums1))
        count.update(set(nums2))
        count.update(set(nums3))

        res = []
        for key in count:
            if count[key] >= 2:
                res.append(key)
        
        return res