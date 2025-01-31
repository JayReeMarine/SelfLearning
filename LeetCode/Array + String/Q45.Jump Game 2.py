#https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150

#https://www.youtube.com/watch?v=dJ7sWiOoK7g

class Solution:
    def jump(self, nums: list[int]) -> int:
        """
        Finds the minimum number of jumps needed to reach the last index.
        The function assumes that it's always possible to reach the last index.

        Args:
        nums (list[int]): A list where nums[i] represents the maximum jump length from index i.

        Returns:
        int: The minimum number of jumps needed to reach the last index.
        """

        # Edge case: If there's only one element, we're already at the last index, so no jumps are needed.
        if len(nums) == 1:
            return 0

        # `jumps` keeps track of the number of jumps taken.
        jumps = 0  

        # `l` (left) represents the current starting index of the jump range.
        # `r` (right) represents the farthest index we can reach in the current jump.
        l = r = 0  

        # Continue jumping until we reach or exceed the last index
        while r < len(nums) - 1:
            # `farthest` tracks the maximum index that can be reached in the next jump.
            farthest = 0  

            # Explore all positions within the current jump range `[l, r]`
            for i in range(l, r + 1):
                # Find the maximum reachable index in the next step
                farthest = max(farthest, i + nums[i])

            # Move the left (`l`) to the next range and update `r` (right) with the farthest reach
            l = r + 1  
            r = farthest  

            # Increment the jump count
            jumps += 1  

        # Return the minimum number of jumps required to reach the last index
        return jumps



Solution = Solution()
nums = [2,3,1,1,4]
print(Solution.jump(nums))  # Output: 2

nums = [2,3,0,1,4]
print(Solution.jump(nums))  # Output: 2


        
