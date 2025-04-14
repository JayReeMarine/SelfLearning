#https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def majorityElement(self, nums: list[int]) -> int:
        """
        Finds the majority element in a list of integers.
        The majority element is the element that appears more than n/2 times, where n is the length of the list.
        
        Args:
        nums (list[int]): The input list of integers.
        
        Returns:
        int: The majority element in the list.
        """
        
        # Sort the list to ensure the majority element is at the middle index
        nums.sort()
        
        # Return the middle element as it is the majority element
        return nums[len(nums) // 2]
    

nums = [3,2,3]
Solution = Solution()
print(Solution.majorityElement(nums))  # Output: 3
nums = [2,2,1,1,1,2,2]
print(Solution.majorityElement(nums))  # Output: 2