#https://leetcode.com/problems/next-greater-element-i/description/

from typing import List

class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1idx = { n:i for i,n in enumerate(nums1)}
        res = [-1] * len(nums1)

        stack = []
        for i in range(len(nums2)):
            cur = nums2[i]
            while stack and cur > stack[-1]:
                val = stack.pop()
                idx = nums1idx[val]
                res[idx] = cur
            if cur in nums1idx:
                stack.append(cur)
        return res

        # res = []
        # for i in range(len(nums1)):
        #     check = False
        #     added = False
        #     for j in range(len(nums2)):
        #         if nums1[i] == nums2[j]:
        #             check = True
                
        #         if check and nums2[j] > nums1[i]:
        #             res.append(nums2[j])
        #             added = True
        #             break

        #     if not added:
        #         res.append(-1)

        # return res