#https://leetcode.com/problems/two-sum/description/

from typing import List

class Solution:
    # O(n^2)
    # def twoSum(self, nums: List[int], target: int) -> List[int]:
    #     for i in range(len(nums)):
    #         for j in range(i+1,len(nums)):
    #             if  nums[i]+ nums[j]  == target:
    #                 return [i,j]
    #     return []
    
    # using a hash table, O(N)
    #https://www.youtube.com/watch?time_continue=333&v=luicuNOBTAI&embeds_referring_euri=https%3A%2F%2Fleetcode.com%2F&source_ve_path=MTM5MTE3LDEyNzI5OSwxMjcyOTksMTI3Mjk5LDEyNzI5OSwxMjcyOTksMjM4NTE
    
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # seen = {}
        # for i in range(len(nums)):
        #     diff = target - nums[i]
        #     if diff in seen:
        #         return [seen[diff],i]
        #     else:
        #         seen[nums[i]] = i
        seen = {}
        for i,num in enumerate(nums):
            diff = target - num
            if diff in seen:
                return [seen[diff], i]
            seen[num] = i
        

nums = [2, 7, 11, 15]
target = 9
solution = Solution()
print(solution.twoSum(nums, target))