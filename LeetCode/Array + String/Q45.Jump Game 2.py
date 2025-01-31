#https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def jump(self, nums: list[int]) -> int:
        # Edge case: If there's only one element, we're already at the last index
        if len(nums) == 1:
            return 1

        # `cap` represents the farthest index we can reach so far.
        cap = nums[0]  # Initialize the maximum reach with the first jump length
        trial = 0  # Initialize the number of jumps taken
        for i in range(1, len(nums)):  # Iterate from index 1 to the end of the array
            if cap < i:
                return -1
            for j in range(i, cap+1 if cap < len(nums) - 1 else len(nums)):
                if j + nums[j] > cap:
                    cap = j + nums[j]
                    trial += 1
        
        if cap >= len(nums) - 1:
                return trial
        return -1

Solution = Solution()
nums = [2,3,1,1,4]
print(Solution.jump(nums))  # Output: 2

nums = [2,3,0,1,4]
print(Solution.jump(nums))  # Output: 2


        
