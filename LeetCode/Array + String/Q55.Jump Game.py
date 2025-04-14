#https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150


class Solution:
    def canJump(self, nums: list[int]) -> bool:
        """
        Determines if it's possible to reach the last index starting from the first index.
        
        Args:
        nums (list[int]): A list where nums[i] represents the maximum jump length from index i.

        Returns:
        bool: True if the last index is reachable, False otherwise.
        """

        # Edge case: If there's only one element, we're already at the last index
        if len(nums) == 1:
            return True

        # `cap` represents the farthest index we can reach so far.
        cap = nums[0]  # Initialize the maximum reach with the first jump length

        for i in range(1, len(nums)):  # Iterate from index 1 to the end of the array
            if cap < i:  
                # If the farthest reach (`cap`) is less than the current index (`i`),
                # we are stuck and cannot move forward, so return False.
                return False
            
            # Update `cap` to be the maximum of the current `cap` or the new reach from `i`
            cap = max(cap, i + nums[i])

            # If `cap` reaches or exceeds the last index, return True
            if cap >= len(nums) - 1:
                return True
        
        # If the loop completes and we haven't returned yet, it means we couldn't reach the last index
        return False

    

Solution = Solution()
nums = [2,3,1,1,4]
print(Solution.canJump(nums))  # Output: True

nums = [3,2,1,0,4]
print(Solution.canJump(nums))  # Output: False

nums = [1,2]
print(Solution.canJump(nums))  # Output: True

  